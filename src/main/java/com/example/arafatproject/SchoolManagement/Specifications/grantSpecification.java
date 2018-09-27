package com.example.arafatproject.SchoolManagement.Specifications;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.Predicate;

import com.example.arafatproject.SchoolManagement.Domain.Authentication._Grant;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

public class grantSpecification {
    public static Specification<_Grant> getGrantBySpecification(Long userId) {
        return ((root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            if (userId > 0L) {
                predicates.add(cb.equal(root.get("id"), userId));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
