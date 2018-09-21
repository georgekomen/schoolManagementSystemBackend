package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain._Group;
import com.example.arafatproject.SchoolManagement.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public _Group newGroup(_Group group) {
        _Group group1 = new _Group(group.getName(), group.getSchool(), group.getCourse(),
                group.getDate_created(), group.getInvoice());

        return groupRepository.save(group1);
    }
}
