package com.example.bb.permission.service;

import java.util.List;

import com.example.bb.permission.model.Permission;
import com.example.bb.role.permission.model.RolePermission;

public interface IPermissionService {
	
	Permission addPermission(Permission permission);
	Permission getPermissionDetail(Long permissionId);
	List<Permission> getPermissionList();
	Permission updatePermission(Long permissionId,Permission permission);
	void deletePermission(Long permissionId);
	
	RolePermission addRolePermission(RolePermission rolePermission);
	RolePermission getRolePermissionDetail(Long rolePermissionId);
	List<RolePermission> getRolePermissionList();
	RolePermission updateRolePermission(Long rolePermissionId,RolePermission permission);
	void deleteRolePermission(Long rolePermissionId);
}
