package de.hackerstolz.climathon.escapeapocalypse.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Challenge {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	@JsonInclude
	@Transient
	@URL
	private String iconUrl;

	@NotEmpty
	@JsonInclude
	@Transient
	private List<String> categories;

	@JsonInclude
	@Transient
	private Date start;

	@JsonInclude
	@Transient
	private Date end;

	@JsonInclude
	@Transient
	private String description;

	@JsonInclude
	@Transient
	private long durationInSeconds;

	@JsonInclude
	@Transient
	private int lifePoints;

	@JsonInclude
	@Transient
	@OneToOne
	@JoinColumn(name = "locationId")
	private Location location;

	public Challenge() {
		// jpa
	}

	public Challenge(@NotEmpty String name, @NotEmpty String iconUrl, @NotEmpty List<String> categories, Date start,
			Date end, String description, long durationInSeconds, int lifePoints, Location location) {
		this.name = name;
		this.iconUrl = iconUrl;
		this.categories = categories;
		this.start = start;
		this.end = end;
		this.description = description;
		this.durationInSeconds = durationInSeconds;
		this.lifePoints = lifePoints;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(long durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
