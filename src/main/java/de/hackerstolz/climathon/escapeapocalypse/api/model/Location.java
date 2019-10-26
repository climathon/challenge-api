package de.hackerstolz.climathon.escapeapocalypse.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private long id;

    private long lng;
    private long lat;

    private long radiusInMeters;

    public Location() {
        //jpa
    }

    public Location(long lng, long lat, long radiusInMeters) {
        this.lng = lng;
        this.lat = lat;
        this.radiusInMeters = radiusInMeters;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getRadiusInMeters() {
        return radiusInMeters;
    }

    public void setRadiusInMeters(long radiusInMeters) {
        this.radiusInMeters = radiusInMeters;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
