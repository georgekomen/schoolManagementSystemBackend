package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain._Group;

public interface GroupService {
    _Group newGroup(_Group group);

    List<_Group> getAllGroups();
}
