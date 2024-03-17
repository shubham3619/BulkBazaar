package com.example.bb.role.service;

import java.util.List;

import com.example.bb.role.model.Role;
import com.example.bb.user.role.model.copy.UserRole;

public interface IRoleService {
	
	Role addRole(Role role);
	Role getRoleDetail(Long roleId);
	List<Role> getRoleList();
	Role updateRole(Long roleId,Role role);
	void deleteRole(Long roleId);
	UserRole addUserRole(UserRole userRole);
	UserRole getUserRoleDetail(Long userRoleId);
	List<UserRole> getUserRoleList();
	UserRole updateUserRole(Long userRoleId,UserRole role);
	void deleteUserRole(Long userRoleId);
}
