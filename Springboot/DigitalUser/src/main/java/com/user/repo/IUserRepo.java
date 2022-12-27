package com.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public interface IUserRepo  extends JpaRepository<User, Long>{
	Optional<User> findByEmailId(String emailId);
   // Optional<User> findByUsernameOrEmail(String username, String emailId);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmailId(String emailId);
}
