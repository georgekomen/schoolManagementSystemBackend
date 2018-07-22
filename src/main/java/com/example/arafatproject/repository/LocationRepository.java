package com.example.arafatproject.repository;

import com.example.arafatproject.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
