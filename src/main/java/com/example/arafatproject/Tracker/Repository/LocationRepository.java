package com.example.arafatproject.Tracker.Repository;

import com.example.arafatproject.Tracker.Domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
