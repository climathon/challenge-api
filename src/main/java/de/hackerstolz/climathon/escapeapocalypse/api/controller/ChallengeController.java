package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import de.hackerstolz.climathon.escapeapocalypse.api.model.Challenge;
import de.hackerstolz.climathon.escapeapocalypse.api.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
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

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateChallenge(@RequestBody Challenge challenge, @PathVariable("id") Long id){
		Optional<Challenge> challengeOptional = challengeRepository.findById(id);
		if(!challengeOptional.isPresent()) {
			throw new IllegalArgumentException("challenge not found");
		}
		challengeRepository.save(challenge);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void updateChallenge(@RequestBody Challenge challenge){
		challengeRepository.save(challenge);
	}


}
