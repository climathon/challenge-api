package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import de.hackerstolz.climathon.escapeapocalypse.api.model.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

}
