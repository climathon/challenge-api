package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import de.hackerstolz.climathon.escapeapocalypse.api.model.U_Group;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<U_Group> getGroupAll() {
        return groupRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public U_Group readById(@PathVariable("id") Long id) {
        Optional<U_Group> optionalU_group = groupRepository.findById(id);
        return optionalU_group.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateGroup(@RequestBody U_Group group, @PathVariable("id") Long id) {
        Optional<U_Group> groupOptional = groupRepository.findById(id);
        if (!groupOptional.isPresent()) {
            throw new IllegalArgumentException("challenge not found");
        }
        groupRepository.save(group);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateGroup(@RequestBody U_Group group) {
        groupRepository.save(group);
    }

}
