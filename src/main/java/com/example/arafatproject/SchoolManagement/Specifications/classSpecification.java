package com.example.arafatproject.SchoolManagement.Specifications;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.criteria.Predicate;

import com.example.arafatproject.SchoolManagement.Domain._Class;
import org.springframework.data.jpa.domain.Specification;

public class classSpecification {
    public static Specification<_Class> getClassSpecification(Long courseId, Date start_date) {
        return ((root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            if (courseId != null && courseId > 0L) {
                predicates.add(cb.equal(root.get("course"), courseId));
            }
            if (start_date != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("start_date"), start_date));
            }
            if (start_date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(start_date);
                calendar.add(Calendar.YEAR, 1);
                predicates.add(cb.lessThanOrEqualTo(root.get("start_date"), calendar.getTime()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }
}
