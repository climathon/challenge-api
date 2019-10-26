package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.EaUser;
import de.hackerstolz.climathon.escapeapocalypse.api.model.Location;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.LocationRepository;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.UserRepository;

@RestController
@RequestMapping(Constants.API + Constants.LOCATIONS)
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Location readById(@PathVariable("id") Long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        return locationOptional.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void createLocation(@RequestBody Location location, @PathVariable("id") Long id){
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if(!optionalLocation.isPresent()) {
            throw new IllegalArgumentException("location not found");
        }
        locationRepository.save(location);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createLocation(@RequestBody Location user){
        locationRepository.save(user);
    }

}
