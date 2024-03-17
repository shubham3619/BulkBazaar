package com.example.bb.user.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bb.core.Utils;
import com.example.bb.email.IEmailService;
import com.example.bb.exception.BusinessException;
import com.example.bb.security.JwtUtil;
import com.example.bb.user.model.Users;
import com.example.bb.user.model.UsersEntity;
import com.example.bb.user.repo.UserRepository;

import lombok.extern.log4j.Log4j2;



@Service
@Log4j2
public class UserService implements IUserService , UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired @Lazy
	private PasswordEncoder passwordEncoder;
	
    @Autowired @Lazy
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private IEmailService emailService;
	
	@Override
	public Users signup(Users user){
		try {
			
			if(userRepository.findByUsernameAndDeletedIndFalse(user.getUsername()).isPresent()) {
				throw new BusinessException("User with same username already exists.");
			}
			
			UsersEntity userEntity = user.populateUserEntity();
			String randomPassword = Utils.getRandomPassword();
			userEntity.setPassword(passwordEncoder.encode(randomPassword));
			if (userEntity.getEffectiveDate() == null) {
				log.debug("Set todays date as effective date");
				userEntity.setEffectiveDate(LocalDate.now());
			} 
			userEntity = userRepository.save(userEntity);
			log.debug("User added sucessfully.");
			
			user = new Users(userEntity);
			user.setPassword(randomPassword);
			emailService.sendAddUserEmail(user);
			user.setPassword(null);
			return user;
		}
		catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Users signIn(Users user){
		try {
			log.debug("Authenticating user..");
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Invalid User");
		}
		
		log.debug("loading user details..");
		UserDetails userDetails = this.loadUserByUsername(user.getUsername());

		String token = this.jwtUtil.generateToken(userDetails);

		log.debug("JWT token" + token);
		Users users = new Users();
		users.setToken(token);
		log.debug("login token sent ..");
		return users;
	}

	@Override
    public User loadUserByUsername(String username){
        Optional<UsersEntity> userOp = userRepository.findByUsernameAndDeletedIndFalse(username);
        if (userOp.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(
            userOp.get().getUsername(),
            userOp.get().getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
	
	@Override
	public Users getUserDetail(Long id){
		Optional<UsersEntity> userEntity = userRepository.findById(id);
		if (userEntity.isPresent()) {
			return new Users(userEntity.get());
		} else {
			throw new BusinessException("User does not exist.");
		}
	}
	
	@Override
	public List<Users> getUserList(){
		List<Users> users = new ArrayList<>();
		List<UsersEntity> userEntityList = userRepository.findAll();
		if (userEntityList!=null && !userEntityList.isEmpty()) {
			for(UsersEntity userEntity: userEntityList) {
				users.add(new Users(userEntity));				
			}
		}
		return users;
	}
	
	@Override
	public Users updateUser(Long userId,Users user){
		Optional<UsersEntity> currentUserEntityOp = userRepository.findById(userId);
		if (currentUserEntityOp.isPresent()) {
			UsersEntity currentUserEntity = currentUserEntityOp.get();
			UsersEntity userEntity = user.populateUserEntity();
			userEntity.setPassword(currentUserEntity.getPassword());;
			if(userEntity.equals(currentUserEntity)) {
				userRepository.save(userEntity);
			}else {
				log.debug("User detals are same");
			}
			
		} else {
			throw new BusinessException("User does not exist.");
		}
		return user;
	}
	
	@Override
	public void deleteUser(Long userId){
		Optional<UsersEntity> currentUserEntityOp = userRepository.findById(userId);
		if (currentUserEntityOp.isPresent()) {
			UsersEntity userEntity = currentUserEntityOp.get();
			userEntity.setDeletedInd(true);;
			userRepository.save(userEntity);
		} else {
			throw new BusinessException("User does not exist.");
		}
	}
	
	@Override
	public void validatePassword(Users user){
		Optional<UsersEntity> currentUserEntityOp = userRepository.findByUsernameAndDeletedIndFalse(user.getUsername());
		if (currentUserEntityOp.isPresent()) {
			UsersEntity userEntity = currentUserEntityOp.get();
			if(user.getToken().equals(userEntity.getValidOtp())) {
				if(userEntity.getValidOtpTime().isEqual(LocalDate.now())) {
					userEntity.setValidOtp(null);
					userEntity.setValidOtpTime(null);
					userEntity.setPassword(passwordEncoder.encode(user.getPassword()));;
					userRepository.save(userEntity);
					
					emailService.sendResetPasswordConfirmationEmail(new Users(userEntity));

				}else {
					throw new BusinessException("OTP time is over.Please re-generate OTP.");
				}
			}else {
				throw new BusinessException("OTP invalid.");
			}
		} else {
			throw new BusinessException("User does not exist.");
		}
	}
	
	@Override
	public void forgotPassword(String userName){
		Optional<UsersEntity> currentUserEntityOp = userRepository.findByUsernameAndDeletedIndFalse(userName);
		if (currentUserEntityOp.isPresent()) {
			try {
			UsersEntity userEntity = currentUserEntityOp.get();
			String randomNumber =  Utils.getRandomNumber();
			if (userEntity.getValidOtp() == null || userEntity.getValidOtp().isEmpty() || userEntity.getValidOtpTime().isBefore(LocalDate.now())) {
				userEntity.setValidOtp(randomNumber.toString());
				userEntity.setValidOtpTime(LocalDate.now());
				userRepository.save(userEntity);
			} 
			Users user = new Users(userEntity);
			user.setValidOtp(userEntity.getValidOtp());
			user.setValidOtpTime(userEntity.getValidOtpTime());
			emailService.sendForgotPasswordEmail(user);
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new BusinessException(e.getMessage());
			}
		} else {
			throw new BusinessException("User does not exist.");
		}
	}
	
	@Override
	public void resetPassword(Users user){
		Optional<UsersEntity> currentUserEntityOp = userRepository.findById(user.getId());
		if (currentUserEntityOp.isPresent()) {
			UsersEntity currentUserEntity = currentUserEntityOp.get();
			currentUserEntity.setPassword(passwordEncoder.encode(currentUserEntity.getPassword()));;
			userRepository.save(currentUserEntity);
		} else {
			throw new BusinessException("User does not exist.");
		}
	}
}
