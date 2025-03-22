package com.rapidcode.api.meter;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;


public class MeterSpecification {

    public static Specification<Meter> hasStatus(MeterStatus status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) {
                return criteriaBuilder.conjunction(); // No filtering if status is null
            }
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<Meter> hasUserName(String userName) {
        return (root, query, criteriaBuilder) -> {
            if (userName == null || userName.isEmpty()) {
                return criteriaBuilder.conjunction(); // No filtering if userName is null or empty
            }
            Join<Object, Object> userJoin = root.join("user"); // Join with the User entity
            return criteriaBuilder.like(criteriaBuilder.lower(userJoin.get("usersName")), "%" + userName.toLowerCase() + "%");
        };
    }
}