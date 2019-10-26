package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.Challenge;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API + Constants.CHALLENGES)
public class ChallengeController {
	Logger LOGGER = LoggerFactory.getLogger(ChallengeController.class);

	@Autowired
	private ChallengeRepository challengeRepository;

	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Challenge> getChallenges() {
		return challengeRepository.findAll();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Challenge readById(@PathVariable("id") Long id) {
		Optional<Challenge> optionalChallenge = challengeRepository.findById(id);
		return optionalChallenge.get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE})
	public void createChallenge(@RequestBody Challenge challenge, @PathVariable("id") Long id){
		LOGGER.info("Update challenge");
		Optional<Challenge> challengeOptional = challengeRepository.findById(id);
		if(!challengeOptional.isPresent()) {
			throw new IllegalArgumentException("challenge not found");
		}
		challenge.setId(id);
		challengeRepository.save(challenge);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE})
	public void createChallenge(@RequestBody Challenge challenge){
		LOGGER.info("Create challenge");
		challengeRepository.save(challenge);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteChallenge(@PathVariable Long id) {
		LOGGER.info("Delete challenge with ID:" + id);
		challengeRepository.deleteById(id);
	}


}
