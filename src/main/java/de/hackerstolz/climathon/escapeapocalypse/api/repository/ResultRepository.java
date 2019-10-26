package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import java.util.List;

import de.hackerstolz.climathon.escapeapocalypse.api.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
	List<Result> findByUserId(Long userId);
}
