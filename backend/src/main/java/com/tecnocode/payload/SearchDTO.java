package com.tecnocode.payload;

public class SearchDTO {

    private Float lat;
    private Float lng;
    private Integer range_distance;
    private Integer experience_year;
    private String genre;
    private String[] language;
    private String[] skill;
    private String qualification;

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Integer getRange_distance() {
        return range_distance;
    }

    public void setRange_distance(Integer range_distance) {
        this.range_distance = range_distance;
    }

    public Integer getExperience_year() {
        return experience_year;
    }

    public void setExperience_year(Integer experience_year) {
        this.experience_year = experience_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
