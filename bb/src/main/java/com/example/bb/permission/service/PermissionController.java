package com.example.bb.permission.service;

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
import com.example.bb.permission.model.Permission;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("api/permission")
@CrossOrigin(origins = "*")
@Log4j2
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("")
	public ResponseEntity<Permission> addPermission(@RequestBody @Valid Permission permission) {
		log.debug("adding permission ..");
		try {
			Permission permissionResult = permissionService.addPermission(permission);
			return new ResponseEntity<Permission>(permissionResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Permission> getPermission(@PathVariable("id") Long id) {
		log.debug("fetching permissions ..");
		try {
			Permission permissionDetails = permissionService.getPermissionDetail(id);
			return new ResponseEntity<Permission>(permissionDetails, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Permission>> getAllPermission() {
		log.debug("fetching permission list ..");
		try {
			List<Permission> permissionList = permissionService.getPermissionList();
			return new ResponseEntity<List<Permission>>(permissionList, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Permission> updatePermission(@PathVariable("id") Long id, @RequestBody Permission user) {
		log.debug("updating permission list ..");
		try {
			Permission permissionResult = permissionService.updatePermission(id, user);
			return new ResponseEntity<Permission>(permissionResult, HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletePermission(@PathVariable("id") Long id) {
		log.debug("deleting permission ..");
		try {
			permissionService.deletePermission(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage());
			throw new BusinessException(e.getMessage());
		}
	}

}
