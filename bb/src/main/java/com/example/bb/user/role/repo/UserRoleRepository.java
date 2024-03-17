package com.example.bb.user.role.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bb.user.role.model.copy.UserRoleEntity;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>{

}
