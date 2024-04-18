package com.azanes.surveybuilder.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "question_form")
public class QuestionForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String question;
    private String answerType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_question_form_id", referencedColumnName = "id")
    private List<ChoicesForm> choicesForms;

    public QuestionForm() {
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

    public List<ChoicesForm> getChoicesForms() {
        return choicesForms;
    }

    public void setChoicesForms(List<ChoicesForm> choicesForms) {
        this.choicesForms = choicesForms;
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
