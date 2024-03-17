package com.example.bb.role.permission.model;

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
public class RolePermission extends Base{
	
	private Long id;
	
	private Long role;
	
	private Long permission;
	
	public RolePermission(RolePermissionEntity permissionEntity) {
	  super(permissionEntity);
	  this.id=permissionEntity.getId(); 
	  this.role=permissionEntity.getRole();	
	  this.permission=permissionEntity.getPermission();
	}
	
	public RolePermissionEntity populateRolePermissionEntity() {
		RolePermissionEntity  permissionEntity =new RolePermissionEntity();
		permissionEntity.setId(getId());
		permissionEntity.setRole(getRole());
		permissionEntity.setPermission(getPermission());
		return permissionEntity;
	}
	
}
