package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.hackerstolz.climathon.escapeapocalypse.api.model.EaUser;
import de.hackerstolz.climathon.escapeapocalypse.api.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
