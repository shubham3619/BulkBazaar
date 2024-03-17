package com.example.bb.role.service;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bb.exception.BusinessException;
import com.example.bb.permission.service.IPermissionService;
import com.example.bb.role.model.Role;
import com.example.bb.role.permission.model.RolePermission;
import com.example.bb.user.role.model.copy.UserRole;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("api/role")
@CrossOrigin(origins = "*")
@Log4j2
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;

	@PostMapping("")
	public ResponseEntity<Role> addRole(@RequestBody @Valid Role role) {
		log.debug("adding role ..");
		try {
			Role roleResult = roleService.addRole(role);
			return new ResponseEntity<Role>(roleResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Role> getRoleDetail(@PathVariable("id") Long id) {
		log.debug("fetching roles ..");
		try {
			Role roleDetails = roleService.getRoleDetail(id);
			return new ResponseEntity<Role>(roleDetails, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Role>> getAllRole() {
		log.debug("fetching role list ..");
		try {
			List<Role> roleList = roleService.getRoleList();
			return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Role> updateRole(@PathVariable("id") Long id, @RequestBody Role user) {
		log.debug("updating role list ..");
		try {
			Role userResult = roleService.updateRole(id, user);
			return new ResponseEntity<Role>(userResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
		log.debug("deleting role ..");
		try {
			roleService.deleteRole(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@PostMapping("role")
	public ResponseEntity<UserRole> addUserRole(@RequestBody @Valid UserRole userRole) {
		log.debug("adding userRole ..");
		try {
			UserRole userRoleResult = roleService.addUserRole(userRole);
			return new ResponseEntity<UserRole>(userRoleResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("role/{id}")
	public ResponseEntity<UserRole> getUserRoleDetail(@PathVariable("id") Long id) {
		log.debug("fetching userRoles ..");
		try {
			UserRole userRoleDetails = roleService.getUserRoleDetail(id);
			return new ResponseEntity<UserRole>(userRoleDetails, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("role")
	public ResponseEntity<List<UserRole>> getAllUserRole() {
		log.debug("fetching userRole list ..");
		try {
			List<UserRole> userRoleList = roleService.getUserRoleList();
			return new ResponseEntity<List<UserRole>>(userRoleList, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@PutMapping("role/{id}")
	public ResponseEntity<UserRole> updateUserRole(@PathVariable("id") Long id, @RequestBody UserRole user) {
		log.debug("updating userRole list ..");
		try {
			UserRole userRoleResult = roleService.updateUserRole(id, user);
			return new ResponseEntity<UserRole>(userRoleResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@DeleteMapping("role/{id}")
	public ResponseEntity<Void> deleteUserRole(@PathVariable("id") Long id) {
		log.debug("deleting userRole ..");
		try {
			roleService.deleteUserRole(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}
	
	@PostMapping("permission")
	public ResponseEntity<RolePermission> addRolePermission(@RequestBody @Valid RolePermission rolePermission) {
		log.debug("adding role permission ..");
		try {
			RolePermission rolePermissionResult = permissionService.addRolePermission(rolePermission);
			return new ResponseEntity<RolePermission>(rolePermissionResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("permission/{id}")
	public ResponseEntity<RolePermission> getRolePermissionDetail(@PathVariable("id") Long id) {
		log.debug("fetching role permission ..");
		try {
			RolePermission rolePermissionDetails = permissionService.getRolePermissionDetail(id);
			return new ResponseEntity<RolePermission>(rolePermissionDetails, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("permission")
	public ResponseEntity<List<RolePermission>> getAllRolePermission() {
		log.debug("fetching role permission list ..");
		try {
			List<RolePermission> rolePermissionList = permissionService.getRolePermissionList();
			return new ResponseEntity<List<RolePermission>>(rolePermissionList, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@PutMapping("permission/{id}")
	public ResponseEntity<RolePermission> updateRolePermission(@PathVariable("id") Long id, @RequestBody RolePermission user) {
		log.debug("updating role permission list ..");
		try {
			RolePermission rolePermissionResult = permissionService.updateRolePermission(id, user);
			return new ResponseEntity<RolePermission>(rolePermissionResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@DeleteMapping("permission/{id}")
	public ResponseEntity<Void> deleteRolePermission(@PathVariable("id") Long id) {
		log.debug("deleting role permission ..");
		try {
			permissionService.deleteRolePermission(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

}
