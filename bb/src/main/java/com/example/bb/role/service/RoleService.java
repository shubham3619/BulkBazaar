package com.example.bb.role.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bb.exception.BusinessException;
import com.example.bb.role.model.Role;
import com.example.bb.role.model.RoleEntity;
import com.example.bb.role.repo.RoleRepository;
import com.example.bb.user.role.model.copy.UserRole;
import com.example.bb.user.role.model.copy.UserRoleEntity;
import com.example.bb.user.role.repo.UserRoleRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RoleService implements IRoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public Role addRole(Role role){
		try {
			RoleEntity roleEntity = role.populateRoleEntity();
			if (roleEntity.getEffectiveDate() == null) {
				log.debug("Set todays date as effective date");
				roleEntity.setEffectiveDate(LocalDate.now());
			} 
			roleEntity = roleRepository.save(roleEntity);
			log.debug("User added sucessfully.");
			return new Role(roleEntity);
		}
		catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public Role getRoleDetail(Long id){
		Optional<RoleEntity> roleEntity = roleRepository.findById(id);
		if (roleEntity.isPresent()) {
			return new Role(roleEntity.get());
		} else {
			throw new BusinessException("Role does not exist.");
		}
	}
	
	@Override
	public List<Role> getRoleList(){
		List<Role> roles = new ArrayList<>();
		List<RoleEntity> roleEntityList = roleRepository.findAll();
		if (roleEntityList!=null && !roleEntityList.isEmpty()) {
			for(RoleEntity userEntity: roleEntityList) {
				roles.add(new Role(userEntity));				
			}
		}
		return roles;
	}
	
	@Override
	public Role updateRole(Long roleId,Role role){
		Optional<RoleEntity> currentRoleEntityOp = roleRepository.findById(roleId);
		if (currentRoleEntityOp.isPresent()) {
			RoleEntity currentRoleEntity = currentRoleEntityOp.get();
			RoleEntity roleEntity = role.populateRoleEntity();
			if(roleEntity.equals(currentRoleEntity)) {
				roleRepository.save(roleEntity);
			}else {
				log.debug("Role detals are same.");
			}
			
		} else {
			throw new BusinessException("Role does not exist.");
		}
		return role;
	}
	
	@Override
	public void deleteRole(Long roleId){
		Optional<RoleEntity> currentUserEntityOp = roleRepository.findById(roleId);
		if (currentUserEntityOp.isPresent()) {
			RoleEntity userEntity = currentUserEntityOp.get();
			userEntity.setDeletedInd(true);;
			roleRepository.save(userEntity);
		} else {
			throw new BusinessException("Role does not exist.");
		}
	}
	
	@Override
	public UserRole addUserRole(UserRole role){
		try {
			UserRoleEntity userRoleEntity = role.populateUserRoleEntity();
			if (userRoleEntity.getEffectiveDate() == null) {
				log.debug("Set todays date as effective date");
				userRoleEntity.setEffectiveDate(LocalDate.now());
			} 
			userRoleEntity = userRoleRepository.save(userRoleEntity);
			log.debug("User added sucessfully.");
			return new UserRole(userRoleEntity);
		}
		catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public UserRole getUserRoleDetail(Long id){
		Optional<UserRoleEntity> roleEntity = userRoleRepository.findById(id);
		if (roleEntity.isPresent()) {
			return new UserRole(roleEntity.get());
		} else {
			throw new BusinessException("UserRole does not exist.");
		}
	}
	
	@Override
	public List<UserRole> getUserRoleList(){
		List<UserRole> userRoles = new ArrayList<>();
		List<UserRoleEntity> userRoleEntityList = userRoleRepository.findAll();
		if (userRoleEntityList!=null && !userRoleEntityList.isEmpty()) {
			for(UserRoleEntity userRoleEntity: userRoleEntityList) {
				userRoles.add(new UserRole(userRoleEntity));				
			}
		}
		return userRoles;
	}
	
	@Override
	public UserRole updateUserRole(Long roleId,UserRole role){
		Optional<UserRoleEntity> currentUserRoleEntityOp = userRoleRepository.findById(roleId);
		if (currentUserRoleEntityOp.isPresent()) {
			UserRoleEntity currentUserRoleEntity = currentUserRoleEntityOp.get();
			UserRoleEntity userRoleEntity = role.populateUserRoleEntity();
			if(userRoleEntity.equals(currentUserRoleEntity)) {
				userRoleRepository.save(userRoleEntity);
			}else {
				log.debug("UserRole detals are same.");
			}
			
		} else {
			throw new BusinessException("UserRole does not exist.");
		}
		return role;
	}
	
	@Override
	public void deleteUserRole(Long roleId){
		Optional<UserRoleEntity> currentUserRoleEntityOp = userRoleRepository.findById(roleId);
		if (currentUserRoleEntityOp.isPresent()) {
			UserRoleEntity userRoleEntity = currentUserRoleEntityOp.get();
			userRoleEntity.setDeletedInd(true);;
			userRoleRepository.save(userRoleEntity);
		} else {
			throw new BusinessException("UserRole does not exist.");
		}
	}

}
