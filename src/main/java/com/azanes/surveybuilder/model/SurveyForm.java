package com.azanes.surveybuilder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "survey_form")
public class SurveyForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String surveyFormName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_survey_form_id", referencedColumnName = "id")
    private List<QuestionForm> questionForms;

    public SurveyForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<QuestionForm> getQuestionForms() {
        return questionForms;
    }

    public void setQuestionForms(List<QuestionForm> questionForms) {
        this.questionForms = questionForms;
    }

    public String getSurveyFormName() {
        return surveyFormName;
    }

    public void setSurveyFormName(String surveyFormName) {
        this.surveyFormName = surveyFormName;
    }

    @Override
    public String toString() {
        return "SurveyForm{" +
                "id=" + id +
                ", surveyFormName='" + surveyFormName + '\'' +
                ", questionForms=" + questionForms +
                '}';
    }
}
