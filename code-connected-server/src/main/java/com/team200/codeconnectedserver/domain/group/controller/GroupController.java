package com.team200.codeconnectedserver.domain.group.controller;

import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.group.services.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class GroupController {
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @PostMapping
    public ResponseEntity<Group> create(@RequestBody Group group){
        groupService.create(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }
    @PostMapping
    public  ResponseEntity<Group>


}
