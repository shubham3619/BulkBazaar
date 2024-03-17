package com.example.bb.user.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.bb.base.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UsersEntity extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private Long phone;

	@Column(name="gender")
	private Integer gender;
	
	@Column(name="valid_otp")
	private String validOtp;

	@Column(name="valid_otp_time")
	private LocalDate validOtpTime;
	
}
