package com.sp.services.groups;

import com.sp.entities.Group;

import java.util.Optional;

public interface IGroupService {
    Group addGroup(Group user);
    Iterable<Group> getGroups();
    Optional<Group> getGroup(Long id);
}
