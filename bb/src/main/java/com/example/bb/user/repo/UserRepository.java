package com.example.bb.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bb.user.model.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long>{

	 Optional<UsersEntity> findByUsernameAndDeletedIndFalse(String username);
}
