package com.example.bb.user.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import com.example.bb.base.model.Base;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users extends Base{
	
	private Long id;
	
	@NotNull( message="Username is required.")
	private String username;
	
	@NotNull(message="First name is required.")
	private String firstName;
	
	@NotNull(message="Last name is required.")
	private String lastName;
	private String middleName;
	
	private String password;
	
	@Email(message="Business email is required.")
	private String email;
	
	@NotNull(message="User phone is required.")
	private Long phone;
	
	private Integer gender;
	private String token;
	
	private String validOtp;

	private LocalDate validOtpTime;
	
	public Users(UsersEntity userEntity) {
	  super(userEntity);
	  this.id=userEntity.getId();
	  this.username=userEntity.getUsername();
	  this.firstName=userEntity.getFirstName();
	  this.lastName=userEntity.getLastName();
	  this.middleName=userEntity.getMiddleName();
	  this.email=userEntity.getEmail();
	  this.phone=userEntity.getPhone();
	  this.gender=userEntity.getGender();
	}
	
	public UsersEntity populateUserEntity() {
		UsersEntity userEntity = new UsersEntity();
		userEntity.setId(getId());
		userEntity.setFirstName(getFirstName());
		userEntity.setMiddleName(getMiddleName());
		userEntity.setLastName(getLastName());
		userEntity.setPhone(getPhone());
		userEntity.setEmail(getEmail());
		userEntity.setGender(getGender());
		userEntity.setUsername(getUsername());
		super.populateBaseEntity();
		return userEntity;
	}
	
}
