package com.example.bb.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bb.permission.model.PermissionEntity;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long>{

}
