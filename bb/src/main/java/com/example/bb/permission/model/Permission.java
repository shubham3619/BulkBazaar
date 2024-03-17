package com.example.bb.permission.model;

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
public class Permission extends Base{
	
	private Long id;
	
	private String name;
	
	private String description;
	
	public Permission(PermissionEntity permissionEntity) {
	  super(permissionEntity);
	  this.id=permissionEntity.getId(); 
	  this.name=permissionEntity.getName();	
	  this.description=permissionEntity.getDescription();
	}
	
	public PermissionEntity populatePermissionEntity() {
		PermissionEntity  permissionEntity =new PermissionEntity();
		permissionEntity.setId(getId());
		permissionEntity.setName(getName());
		permissionEntity.setDescription(getDescription());
		return permissionEntity;
	}
	
}
