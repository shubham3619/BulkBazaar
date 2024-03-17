package com.example.bb.business.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.example.bb.base.model.Base;
import com.example.bb.core.Address;
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
public class Business extends Base{
	
	private Long id;
	
	@NotNull(message="Business name is required.")
	private String name;
	
	@NotNull(message="Business type is required.")
	private String type;

	private String website;
	
	@NotNull(message="Business email is required.")
	@NotEmpty(message="Business email is required.")
	private String email;
	
	@NotNull(message="Business phone number is required.")
	private String phone;
	
	@NotNull(message="GST number is required.")
	private String gstNo;
	
	private Address address;
	
	@NotNull(message="User for business is required.")
	private Long userId;
	
	public Business(BusinessEntity businessEntity) {
	  super(businessEntity);
	  this.id=businessEntity.getId(); 
	  this.name=businessEntity.getName();	
	  this.type=businessEntity.getType();
	  this.website=businessEntity.getWebsite();
	  this.email=businessEntity.getEmail();
	  this.phone=businessEntity.getPhone();
	  this.gstNo=businessEntity.getGstNo();
	  this.userId=businessEntity.getUserId(); 	
	  Address address = new Address();
//	  address.getaddressLine1=businessEntity.getAddressLine1();
//	  address.addressLine2=businessEntity.getAddressLine2();
//	  address.city=businessEntity.getCity();
//	  address.state=businessEntity.getState();
//	  address.country=businessEntity.getCountry();
//	  address.pinCode=businessEntity.getPinCode();
	  this.address = address;
	}
	
	public BusinessEntity populateUserEntity() {
		BusinessEntity  businessEntity =new BusinessEntity();
		businessEntity.setId(getId());
		businessEntity.setName(getName());
		businessEntity.setType(getType());
		businessEntity.setWebsite(getWebsite());
		businessEntity.setEmail(getEmail());
		businessEntity.setPhone(getPhone());
		businessEntity.setGstNo(getGstNo());
		businessEntity.setAddressLine1(getAddress().getAddressLine1());
		businessEntity.setAddressLine2(getAddress().getAddressLine2());
		businessEntity.setCity(getAddress().getCity());
		businessEntity.setState(getAddress().getState());
		businessEntity.setCountry(getAddress().getCountry());
		businessEntity.setPinCode(getAddress().getPinCode());
		businessEntity.setUserId(getUserId());
		return businessEntity;
	}
	
}
