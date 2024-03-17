package com.example.bb.user.role.model.copy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.bb.base.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_role")
public class UserRoleEntity extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="role")
	private Long role;
	
	@Column(name="user")
	private Long user;
	
}
