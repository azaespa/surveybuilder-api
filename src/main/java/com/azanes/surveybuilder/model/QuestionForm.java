package com.azanes.surveybuilder.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "question_form")
public class QuestionForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String question;
    private String answerType;

    public QuestionForm() {
    }

    public QuestionForm(String question, String answerType) {
        this.question = question;
        this.answerType = answerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    @Override
    public String toString() {
        return "QuestionForm{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answerType='" + answerType + '\'' +
                '}';
    }
}
