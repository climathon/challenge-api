package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import de.hackerstolz.climathon.escapeapocalypse.api.model.EaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EaUser, Long> {
}
