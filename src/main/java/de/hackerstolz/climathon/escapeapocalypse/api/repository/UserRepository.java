package de.hackerstolz.climathon.escapeapocalypse.api.repository;

import de.hackerstolz.climathon.escapeapocalypse.api.model.U_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<U_User, Long> {
}
