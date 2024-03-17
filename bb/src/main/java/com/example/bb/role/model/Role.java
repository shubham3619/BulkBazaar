package com.example.bb.role.model;

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
public class Role extends Base{
	
	private Long id;
	
	private String name;
	
	public Role(RoleEntity roleEntity) {
	  super(roleEntity);
	  this.id=roleEntity.getId(); 
	  this.name=roleEntity.getName();	
	}
	
	public RoleEntity populateRoleEntity() {
		RoleEntity  roleEntity =new RoleEntity();
		roleEntity.setId(getId());
		roleEntity.setName(getName());
		return roleEntity;
	}
	
}
