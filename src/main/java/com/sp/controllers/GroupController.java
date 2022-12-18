package com.sp.controllers;

import java.util.Optional;

import com.sp.entities.Group;
import com.sp.services.groups.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class GroupController {
    private Logger logger = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private IGroupService groupService;

    @GetMapping("/groups")
    public Iterable<Group> getGroups(){
        logger.info("-> GroupController getGroups...");
        return groupService.getGroups();
    }

    @GetMapping("/group/{id}")
    public Optional<Group> getGroup(@PathVariable Long id){
        logger.info("-> GroupController getGroupId: " + id);
        return groupService.getGroup(id);
    }

    @PostMapping("/group")
    public Group addGroup(@RequestBody Group group){
        logger.info("-> GroupController addGroup...");
        return groupService.addGroup(group);
    }
}
