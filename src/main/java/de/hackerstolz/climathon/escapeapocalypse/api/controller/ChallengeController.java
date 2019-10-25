package de.hackerstolz.climathon.escapeapocalypse.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/challenge")
	public String greeting(String name) {
		return "Hello World";
	}
}
