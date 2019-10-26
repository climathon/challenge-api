package de.hackerstolz.climathon.escapeapocalypse.api.controller;


import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.EAMembership;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.MembershipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.API + Constants.MEMBERSHIPS)
public class MembershipController {
    Logger LOGGER = LoggerFactory.getLogger(MembershipController.class);

    @Autowired
    private MembershipRepository membershipRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<EAMembership> getMemberships() {
        return membershipRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public EAMembership readById(@PathVariable("id") Long id) {
        Optional<EAMembership> eaMembershipOptional = membershipRepository.findById(id);
        return eaMembershipOptional.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public void updateMembership(@RequestBody EAMembership eaMembership, @PathVariable("id") Long id){
        LOGGER.info("Update challenge");
        Optional<EAMembership> membershipOptional = membershipRepository.findById(id);
        if(!membershipOptional.isPresent()) {
            throw new IllegalArgumentException("challenge not found");
        }
        eaMembership.setId(id);
        membershipRepository.save(eaMembership);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public void createMembership(@RequestBody EAMembership eaMembership){
        LOGGER.info("Create membership");
        membershipRepository.save(eaMembership);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMembership(@PathVariable Long id) {
        LOGGER.info("Delete challenge with ID:" + id);
        membershipRepository.deleteById(id);
    }

}
