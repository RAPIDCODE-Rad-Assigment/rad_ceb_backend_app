package com.rapidcode.api.complaints;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query("SELECT c FROM Complaint c LEFT JOIN FETCH c.imageBase64List WHERE c.user.id = :userId")
    List<Complaint> findByUserId(@Param("userId") UUID userId); // FIXED




    List<Complaint> findByStatus(Complaint.Status status);

    @Query("SELECT c FROM Complaint c LEFT JOIN FETCH c.imageBase64List LEFT JOIN FETCH c.user WHERE c.id = :id")
    Optional<Complaint> findByIdWithImagesAndUser(@Param("id") Long id);

    // ComplaintRepository.java
    @Query("SELECT c FROM Complaint c " +
            "WHERE (:userId IS NULL OR c.user.id = :userId) " +
            "AND (:roleName IS NULL OR c.user.roles IS NOT EMPTY AND :roleName MEMBER OF c.user.roles) " +
            "AND (:status IS NULL OR c.status = :status)")
    Page<Complaint> findByFilters(@Param("userId") Long userId,
                                  @Param("roleName") String roleName,
                                  @Param("status") Complaint.Status status,
                                  Pageable pageable);

}
