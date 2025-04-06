package com.rapidcode.api.meter;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;


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

    public static Specification<Meter> hasAreaIdIn(List<UUID> areaIds) {
        return (root, query, criteriaBuilder) -> {
            if (areaIds == null || areaIds.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return root.get("area").get("id").in(areaIds);
        };
    }
}