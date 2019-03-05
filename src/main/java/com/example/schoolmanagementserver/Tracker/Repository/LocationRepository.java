package com.example.schoolmanagementserver.Tracker.Repository;

import com.example.schoolmanagementserver.Tracker.Domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
