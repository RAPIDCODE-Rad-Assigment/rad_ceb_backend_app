package com.rapidcode.api.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> , JpaSpecificationExecutor<User> {

    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.tokens WHERE u.email = :email")
    Optional<User> findByEmail(String email);

    Optional<User> findByRoles_Name(String roleName); // Add this method

    Page<User> findAllByEnabled(boolean enabled, Pageable pageable);

    @Query("SELECT u FROM User u WHERE LOWER(u.usersName) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<User> searchUsersByName(@Param("name") String name, Pageable pageable);

    Page<User> findByFullNameContainingIgnoreCaseAndRoles_Name(String fullName, String role, Pageable pageable);

    Page<User> findByFullNameContainingIgnoreCase(String fullName, Pageable pageable);

    Page<User> findByRoles_Name(String role, Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.id NOT IN " +
            "(SELECT u2.id FROM User u2 JOIN u2.roles r WHERE r.name IN :roles)")
    Page<User> findAllExcludingRoles(@Param("roles") List<String> roles, Pageable pageable);

}
