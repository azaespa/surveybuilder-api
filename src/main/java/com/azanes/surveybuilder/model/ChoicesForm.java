package com.azanes.surveybuilder.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "choices_form")
public class ChoicesForm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String choiceLetter;
    private String choice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_form_id")
    @JsonIncludeProperties(value = "id")
    private QuestionForm questionForm;

    public ChoicesForm() {
    }

    public ChoicesForm(String choiceLetter, String choice) {
        this.choiceLetter = choiceLetter;
        this.choice = choice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChoiceLetter() {
        return choiceLetter;
    }

    public void setChoiceLetter(String choiceLetter) {
        this.choiceLetter = choiceLetter;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "ChoicesForm{" +
                "id=" + id +
                ", choiceLetter='" + choiceLetter + '\'' +
                ", choice='" + choice + '\'' +
                '}';
    }
}
