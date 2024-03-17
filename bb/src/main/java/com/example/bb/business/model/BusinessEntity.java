package com.example.bb.business.model;

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
@Table(name="business")
public class BusinessEntity extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="website")
	private String website;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="gst_no")
	private String gstNo;
	
	@Column(name="address_line_1")
	private String addressLine1;
	
	@Column(name="address_line_2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;

	@Column(name="pin_code")
	private String pinCode;
	
	@Column(name="user_id")
	private Long userId;
	
}
