package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain._Group;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "new_group", method = RequestMethod.POST)
    public _Group newGroup(@RequestBody _Group group) {
        return groupService.newGroup(group);
    }

    @RequestMapping(value = "get_groups", method = RequestMethod.GET)
    public List<_Group> getAllGroups(Pageable pageable){
        return groupService.getAllGroups(pageable);
    }
}
