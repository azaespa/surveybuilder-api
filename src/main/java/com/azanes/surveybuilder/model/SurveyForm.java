package com.azanes.surveybuilder.model;

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
    @Column(name="survey_form_id",nullable = false, updatable = false)
    private String surveyFormId;

    private String surveyFormName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_survey_form_id", referencedColumnName = "survey_form_id")
    private List<QuestionForm> questionForm;

    public SurveyForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyFormId() {
        return surveyFormId;
    }

    public void setSurveyFormId(String surveyFormId) {
        this.surveyFormId = surveyFormId;
    }

    public List<QuestionForm> getQuestionForm() {
        return questionForm;
    }

    public void setQuestionForm(List<QuestionForm> questionForm) {
        this.questionForm = questionForm;
    }

    public String getSurveyFormName() {
        return surveyFormName;
    }

    public void setSurveyFormName(String surveyFormName) {
        this.surveyFormName = surveyFormName;
    }

    @Override
    public String toString() {
        return "SurveyForm {" +
                "id=" + id +
                ", questionId='" + surveyFormId + '\'' +
                '}';
    }
}
