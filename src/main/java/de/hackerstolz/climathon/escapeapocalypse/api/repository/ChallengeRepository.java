package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import de.hackerstolz.climathon.escapeapocalypse.api.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    List<Challenge> getChallengesByCollection(Long collectionID);
}
