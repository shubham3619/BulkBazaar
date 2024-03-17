package com.example.bb.role.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bb.role.model.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

}
