package com.sp.services.groups;

import com.sp.entities.Group;
import com.sp.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private GroupRepository userRepository;

    @Override
    public Iterable<Group> getGroups() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Group> getGroup(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Group addGroup(Group user) {
        return userRepository.save(user);
    }

}
