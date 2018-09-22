package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain._Group;
import com.example.arafatproject.SchoolManagement.Repository.GroupRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public _Group newGroup(_Group group) {
        _Group group1 = new _Group(group.getName(), group.getSchool(), group.getCourse(),
                group.getDate_created(), group.getExpected_end_date(), group.getInvoice());

        return groupRepository.save(group1);
    }

    @Override
    public List<_Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
