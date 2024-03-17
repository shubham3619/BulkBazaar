package com.example.bb.role.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bb.role.permission.model.RolePermissionEntity;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Long>{

}
