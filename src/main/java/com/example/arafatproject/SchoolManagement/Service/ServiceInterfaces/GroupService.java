package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain._Group;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    _Group newGroup(_Group group);

    List<_Group> getAllGroups(Pageable pageable);
}
