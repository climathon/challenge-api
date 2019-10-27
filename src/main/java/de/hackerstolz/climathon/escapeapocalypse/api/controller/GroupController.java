package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.EaUserGroup;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(Constants.API + Constants.GROUPS)
@CrossOrigin("*")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<EaUserGroup> getGroupAll() {
        return groupRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public EaUserGroup readById(@PathVariable("id") Long id) {
        Optional<EaUserGroup> optionalU_group = groupRepository.findById(id);
        return optionalU_group.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateGroup(@RequestBody EaUserGroup group, @PathVariable("id") Long id) {
        Optional<EaUserGroup> groupOptional = groupRepository.findById(id);
        if (!groupOptional.isPresent()) {
            throw new IllegalArgumentException("challenge not found");
        }
        groupRepository.save(group);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createGroup(@RequestBody EaUserGroup group) {
        groupRepository.save(group);
    }

}
