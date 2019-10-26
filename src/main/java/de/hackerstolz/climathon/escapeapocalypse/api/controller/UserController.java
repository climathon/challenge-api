package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import de.hackerstolz.climathon.escapeapocalypse.api.model.U_User;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<U_User> getUserAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public U_User readById(@PathVariable("id") Long id) {
        Optional<U_User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody U_User user, @PathVariable("id") Long id){
        Optional<U_User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new IllegalArgumentException("challenge not found");
        }
        userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateUser(@RequestBody U_User user){
        userRepository.save(user);
    }

}
