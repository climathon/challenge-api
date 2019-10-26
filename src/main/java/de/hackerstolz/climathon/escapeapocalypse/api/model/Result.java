package de.hackerstolz.climathon.escapeapocalypse.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
public class Result {

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long challengeId;

    @NotNull
    private Long userId;

    private boolean approved;
    private String status;
    private String proof;
    private LocalDate resultDate;

    public Result() {
    }

    public Result(@NotNull Long challengeId, @NotNull Long userId, boolean approved, String status, String proof,
            LocalDate resultDate) {
        this.challengeId = challengeId;
        this.userId = userId;
        this.approved = approved;
        this.status = status;
        this.proof = proof;
        this.resultDate = resultDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }
}
