package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.Result;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.ResultRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.API + Constants.RESULTS)
@CrossOrigin("*")
public class ResultController {
    Logger LOGGER = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    private ResultRepository resultRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Result readById(@PathVariable("id") Long id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        return optionalResult.get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public void updateResult(@RequestBody Result result, @PathVariable("id") Long id){
        LOGGER.info("Update result");
        Optional<Result> resultOptional = resultRepository.findById(id);
        if(!resultOptional.isPresent()) {
            throw new IllegalArgumentException("challenge not found");
        }
        result.setId(id);
        resultRepository.save(result);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public void createResult(@RequestBody Result result){
        LOGGER.info("Create result");
        result.setResultDate(LocalDate.now());
        resultRepository.save(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteResult(@PathVariable Long id) {
        LOGGER.info("Delete challenge with ID:" + id);
        resultRepository.deleteById(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Result> search(@RequestParam("userId") Long userId) {
        return resultRepository.findByUserId(userId);
    }
}
