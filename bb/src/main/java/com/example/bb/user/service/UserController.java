package com.example.bb.user.service;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bb.exception.BusinessException;
import com.example.bb.user.model.Users;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
@Log4j2
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("signup")
	public ResponseEntity<Users> signup(@RequestBody @Valid Users user) {
		log.debug("signup user ..");
		try {
			Users userResult = userService.signup(user);
			return new ResponseEntity<Users>(userResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@PostMapping("signin")
	public ResponseEntity<Users> signIn(@RequestBody Users user) {
		log.debug("login user ..");
		try {
			Users userResult = userService.signIn(user);
			return new ResponseEntity<Users>(userResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@PostMapping("forgot/password")
	public ResponseEntity<Void> forgotPassword(@RequestParam("userName")String userName) {
		log.debug("forgot user password ..");
		try {
			userService.forgotPassword(userName);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@PostMapping("validate/password")
	public ResponseEntity<Void> validatePassword(@RequestBody Users user) {
		log.debug("validating user ..");
		try {
			userService.validatePassword(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@PostMapping("reset/password")
	public ResponseEntity<Void> resetPassword(@RequestBody Users user) {
		log.debug("reset user password..");
		try {
			userService.resetPassword(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Users> getUserDetail(@PathVariable("id") Long id) {
		log.debug("fetching user ..");
		try {
			Users userResult = userService.getUserDetail(id);
			return new ResponseEntity<Users>(userResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@GetMapping("")
	public ResponseEntity<List<Users>> getAllUsers() {
		log.debug("fetching user list ..");
		try {
			List<Users> userList = userService.getUserList();
			return new ResponseEntity<List<Users>>(userList, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Users> updateUser(@PathVariable("id") Long id,@RequestBody Users user) {
		log.debug("updating user list ..");
		try {
			Users userResult = userService.updateUser(id,user);
			return new ResponseEntity<Users>(userResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		log.debug("deleting user ..");
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
}
