package com.rapidcode.api.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> , JpaSpecificationExecutor<User> {

    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.tokens WHERE u.email = :email")
    Optional<User> findByEmail(String email);

    Optional<User> findByRoles_Name(String roleName); // Add this method

    Page<User> findAllByEnabled(boolean enabled, Pageable pageable);

    @Query("SELECT u FROM User u WHERE LOWER(u.usersName) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<User> searchUsersByName(@Param("name") String name, Pageable pageable);

}
