package com.example.bb.user.role.model.copy;

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
public class UserRole extends Base{
	
	private Long id;
	
	private Long role;
	
	private Long user;
	
	public UserRole(UserRoleEntity userEntity) {
	  super(userEntity);
	  this.id=userEntity.getId(); 
	  this.role=userEntity.getRole();	
	  this.user=userEntity.getUser();
	}
	
	public UserRoleEntity populateUserRoleEntity() {
		UserRoleEntity  userRoleEntity =new UserRoleEntity();
		userRoleEntity.setId(getId());
		userRoleEntity.setRole(getRole());
		userRoleEntity.setUser(getRole());
		return userRoleEntity;
	}
	
}
