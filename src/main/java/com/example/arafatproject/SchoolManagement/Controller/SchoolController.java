package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public School newSchool(@RequestBody School school) {
        return schoolService.newschool(school);
    }

    @RequestMapping(value = "fetchall", method = RequestMethod.GET)
    public List<School> getSchools() {
        return schoolService.getAllSchools();
    }
}
