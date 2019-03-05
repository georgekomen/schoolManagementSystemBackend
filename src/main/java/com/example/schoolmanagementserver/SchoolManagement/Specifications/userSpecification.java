package com.example.schoolmanagementserver.SchoolManagement.Specifications;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Authentication._Grant;
import com.example.schoolmanagementserver.SchoolManagement.Domain.StudentClass;
import com.example.schoolmanagementserver.SchoolManagement.Domain.User;
import com.example.schoolmanagementserver.SchoolManagement.Domain._Class;
import org.springframework.data.jpa.domain.Specification;

public class userSpecification {
    public static Specification<_Grant> getUserBySpecification(_Class class1) {
        return ((root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            if (class1 != null) {
                Join<User, StudentClass> studentClassJoin = root.join("studentClasses");
                predicates.add(cb.equal(studentClassJoin.get("class1"), class1));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
