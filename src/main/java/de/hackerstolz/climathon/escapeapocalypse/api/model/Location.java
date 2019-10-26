package de.hackerstolz.climathon.escapeapocalypse.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private long id;

    private Float lng;
    private Float lat;

    private Long radiusInMeters;

    public Location() {
        //jpa
    }

    public Location(Float lng, Float lat, Long radiusInMeters) {
        this.lng = lng;
        this.lat = lat;
        this.radiusInMeters = radiusInMeters;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Long getRadiusInMeters() {
        return radiusInMeters;
    }

    public void setRadiusInMeters(Long radiusInMeters) {
        this.radiusInMeters = radiusInMeters;
    }
}
