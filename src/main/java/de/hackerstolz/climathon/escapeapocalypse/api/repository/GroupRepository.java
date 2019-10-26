package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import de.hackerstolz.climathon.escapeapocalypse.api.model.EaUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<EaUserGroup, Long> {
}
