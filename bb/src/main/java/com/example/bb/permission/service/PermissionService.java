package com.example.bb.permission.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bb.exception.BusinessException;
import com.example.bb.permission.model.Permission;
import com.example.bb.permission.model.PermissionEntity;
import com.example.bb.permission.repo.PermissionRepository;
import com.example.bb.role.permission.model.RolePermission;
import com.example.bb.role.permission.model.RolePermissionEntity;
import com.example.bb.role.permission.repo.RolePermissionRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PermissionService implements IPermissionService{

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private RolePermissionRepository rolePermissionRepository;

	@Override
	public Permission addPermission(Permission permission){
		try {
			PermissionEntity permissionEntity = permission.populatePermissionEntity();
			if (permissionEntity.getEffectiveDate() == null) {
				log.debug("Set todays date as effective date");
				permissionEntity.setEffectiveDate(LocalDate.now());
			} 
			permissionEntity = permissionRepository.save(permissionEntity);
			log.debug("User added sucessfully.");
			return new Permission(permissionEntity);
		}
		catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public Permission getPermissionDetail(Long id){
		Optional<PermissionEntity> permissionEntity = permissionRepository.findById(id);
		if (permissionEntity.isPresent()) {
			return new Permission(permissionEntity.get());
		} else {
			throw new BusinessException("Permission does not exist.");
		}
	}
	
	@Override
	public List<Permission> getPermissionList(){
		List<Permission> permissions = new ArrayList<>();
		List<PermissionEntity> permissionEntityList = permissionRepository.findAll();
		if (permissionEntityList!=null && !permissionEntityList.isEmpty()) {
			for(PermissionEntity userEntity: permissionEntityList) {
				permissions.add(new Permission(userEntity));				
			}
		}
		return permissions;
	}
	
	@Override
	public Permission updatePermission(Long permissionId,Permission permission){
		Optional<PermissionEntity> currentPermissionEntityOp = permissionRepository.findById(permissionId);
		if (currentPermissionEntityOp.isPresent()) {
			PermissionEntity currentPermissionEntity = currentPermissionEntityOp.get();
			PermissionEntity permissionEntity = permission.populatePermissionEntity();
			if(permissionEntity.equals(currentPermissionEntity)) {
				permissionRepository.save(permissionEntity);
			}else {
				log.debug("Permission detals are same.");
			}
			
		} else {
			throw new BusinessException("Permission does not exist.");
		}
		return permission;
	}
	
	@Override
	public void deletePermission(Long permissionId){
		Optional<PermissionEntity> currentPermissionEntityOp = permissionRepository.findById(permissionId);
		if (currentPermissionEntityOp.isPresent()) {
			PermissionEntity permissionEntity = currentPermissionEntityOp.get();
			permissionEntity.setDeletedInd(true);;
			permissionRepository.save(permissionEntity);
		} else {
			throw new BusinessException("Permission does not exist.");
		}
	}
	
	@Override
	public RolePermission addRolePermission(RolePermission rolePermission){
		try {
			RolePermissionEntity rolePermissionEntity = rolePermission.populateRolePermissionEntity();
			if (rolePermissionEntity.getEffectiveDate() == null) {
				log.debug("Set todays date as effective date");
				rolePermissionEntity.setEffectiveDate(LocalDate.now());
			} 
			rolePermissionEntity = rolePermissionRepository.save(rolePermissionEntity);
			log.debug("Role permission added sucessfully.");
			return new RolePermission(rolePermissionEntity);
		}
		catch(Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public RolePermission getRolePermissionDetail(Long id){
		Optional<RolePermissionEntity> rolePermissionEntity = rolePermissionRepository.findById(id);
		if (rolePermissionEntity.isPresent()) {
			return new RolePermission(rolePermissionEntity.get());
		} else {
			throw new BusinessException("RolePermission does not exist.");
		}
	}
	
	@Override
	public List<RolePermission> getRolePermissionList(){
		List<RolePermission> rolePermissions = new ArrayList<>();
		List<RolePermissionEntity> permissionEntityList = rolePermissionRepository.findAll();
		if (permissionEntityList!=null && !permissionEntityList.isEmpty()) {
			for(RolePermissionEntity permissionEntity: permissionEntityList) {
				rolePermissions.add(new RolePermission(permissionEntity));				
			}
		}
		return rolePermissions;
	}
	
	@Override
	public RolePermission updateRolePermission(Long permissionId,RolePermission permission){
		Optional<RolePermissionEntity> currentRolePermissionEntityOp = rolePermissionRepository.findById(permissionId);
		if (currentRolePermissionEntityOp.isPresent()) {
			RolePermissionEntity currentRolePermissionEntity = currentRolePermissionEntityOp.get();
			RolePermissionEntity permissionEntity = permission.populateRolePermissionEntity();
			if(permissionEntity.equals(currentRolePermissionEntity)) {
				rolePermissionRepository.save(permissionEntity);
			}else {
				log.debug("RolePermission detals are same.");
			}
			
		} else {
			throw new BusinessException("RolePermission does not exist.");
		}
		return permission;
	}
	
	@Override
	public void deleteRolePermission(Long permissionId){
		Optional<RolePermissionEntity> currentRolePermissionEntityOp = rolePermissionRepository.findById(permissionId);
		if (currentRolePermissionEntityOp.isPresent()) {
			RolePermissionEntity permissionEntity = currentRolePermissionEntityOp.get();
			permissionEntity.setDeletedInd(true);;
			rolePermissionRepository.save(permissionEntity);
		} else {
			throw new BusinessException("RolePermission does not exist.");
		}
	}

}
