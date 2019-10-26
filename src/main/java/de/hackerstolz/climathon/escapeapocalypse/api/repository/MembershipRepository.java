package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import de.hackerstolz.climathon.escapeapocalypse.api.model.EAMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<EAMembership, Long> {
}
