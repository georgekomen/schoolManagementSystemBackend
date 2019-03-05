package com.example.schoolmanagementserver.SchoolManagement.Specifications;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.Predicate;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Course;
import org.springframework.data.jpa.domain.Specification;

public class courseSpecification {
    public static Specification<Course> getCourseSpecification(Long schoolId) {
        return ((root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            if (schoolId != null && schoolId > 0L) {
                predicates.add(cb.equal(root.get("school"), schoolId));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
