package com.user.repo;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Role;
import com.user.model.ERoles;

public interface IRoleRepo extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERoles name);

}
