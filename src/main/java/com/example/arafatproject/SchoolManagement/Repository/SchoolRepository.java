package com.example.arafatproject.SchoolManagement.Repository;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "schooldata", path = "schooldata")
public interface SchoolRepository extends JpaRepository<School, Long>, PagingAndSortingRepository<School, Long> {

    List<School> findByName(@Param("name") String name);
    //localhost:5000/schooldata/search/findByName?name=school
}
