package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.AbstractRabbitListenerContainerFactoryConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.Challenge;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.ChallengeRepository;

@RestController
@RequestMapping(Constants.API + Constants.Challenges)
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
	public void updateChallenge(@RequestBody Challenge challenge, @PathVariable("id") Long id){
		LOGGER.info("Update challenge");
		Optional<Challenge> challengeOptional = challengeRepository.findById(id);
		if(!challengeOptional.isPresent()) {
			throw new IllegalArgumentException("challenge not found");
		}
		challenge.setId(id);
		challengeRepository.save(challenge);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE})
	public void updateChallenge(@RequestBody Challenge challenge){
		LOGGER.info("Create challenge");
		challengeRepository.save(challenge);
	}


}
