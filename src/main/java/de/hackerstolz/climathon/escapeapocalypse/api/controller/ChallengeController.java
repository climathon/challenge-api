package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import de.hackerstolz.climathon.escapeapocalypse.api.Constants;
import de.hackerstolz.climathon.escapeapocalypse.api.model.Challenge;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.ChallengeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.API + Constants.CHALLENGES)
@CrossOrigin("*")
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
	public Challenge getChallengeById(@PathVariable("id") Long id) {
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
	public void createChallenge(@RequestBody Challenge challenge){
		LOGGER.info("Create challenge");
		challengeRepository.save(challenge);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteChallenge(@PathVariable Long id) {
		LOGGER.info("Delete challenge with ID:" + id);
		challengeRepository.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public void updateChallengePartial(@RequestBody Challenge challenge, @PathVariable Long id){
		Optional<Challenge> optionalChallenge = challengeRepository.findById(id);
		Challenge persistedChallenge = optionalChallenge.get();
		if(persistedChallenge == null) {
			new IllegalArgumentException("challenge not found");
		}

		if(challenge.getCategory() != null) {
			persistedChallenge.setCategory(challenge.getCategory());
		}

		if(challenge.getDescription() != null) {
			persistedChallenge.setDescription(challenge.getDescription());
		}

		if(challenge.getDurationInSeconds() != null) {
			persistedChallenge.setDurationInSeconds(challenge.getDurationInSeconds());
		}

		if(challenge.getEndDate() != null) {
			persistedChallenge.setEndDate(challenge.getEndDate());
		}

		if(challenge.getIconUrl() != null) {
			persistedChallenge.setIconUrl(challenge.getIconUrl());
		}

		if(challenge.getLifePoints() != null) {
			persistedChallenge.setLifePoints(challenge.getLifePoints());
		}

		if(challenge.getLocationId() != null) {
			persistedChallenge.setLocationId(challenge.getLocationId());
		}

		if(challenge.getName() != null) {
			persistedChallenge.setName(challenge.getName());
		}

		if(challenge.getStartDate() != null) {
			persistedChallenge.setStartDate(challenge.getStartDate());
		}

		challengeRepository.save(persistedChallenge);
	}

	@RequestMapping(value = "/getCollection", method = RequestMethod.GET)
	public List<Challenge> search(@RequestParam("collection_id") Long collectionID) {
		return challengeRepository.getChallengesByCollection(collectionID);
	}
}
