package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.EaUser;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.API + Constants.USERS)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<EaUser> getUserAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public EaUser readById(@PathVariable("id") Long id) {
        Optional<EaUser> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody EaUser user, @PathVariable("id") Long id){
        Optional<EaUser> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new IllegalArgumentException("challenge not found");
        }
        userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateUser(@RequestBody EaUser user){
        userRepository.save(user);
    }

}
