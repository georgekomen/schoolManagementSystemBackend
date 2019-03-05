package com.example.schoolmanagementserver.SchoolManagement.Repository;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Stream;
import com.example.schoolmanagementserver.SchoolManagement.Domain._Class;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface StreamRepository extends JpaRepository<Stream, Long>, JpaSpecificationExecutor {

    @Query("select st from Stream st where st.class1 =?1")
    List<Stream> findByClass(_Class class1, Pageable pageable);
}
