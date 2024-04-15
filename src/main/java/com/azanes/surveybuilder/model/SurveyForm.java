package com.azanes.surveybuilder.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class SurveyForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    @Column(nullable = false, updatable = false)
    private String surveyId;

    public SurveyForm() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public String toString() {
        return "SurveyForm {" +
                "id=" + id +
                ", questionId='" + surveyId + '\'' +
                '}';
    }
}
