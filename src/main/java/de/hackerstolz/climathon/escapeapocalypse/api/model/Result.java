package de.hackerstolz.climathon.escapeapocalypse.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Result {

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private Long challengeId;

    @NotEmpty
    private Long userId;

    private boolean approved;
    private String status;
    private String proof;
    private Date resultDate;

    public Result() {
    }

    public Result(@NotEmpty Long challengeId, @NotEmpty Long userId, boolean approved, String status, String proof,
            Date resultDate) {
        this.challengeId = challengeId;
        this.userId = userId;
        this.approved = approved;
        this.status = status;
        this.proof = proof;
        this.resultDate = resultDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(long challengeId) {
        this.challengeId = challengeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
