package com.azanes.surveybuilder.service;

import com.azanes.surveybuilder.model.QuestionForm;
import com.azanes.surveybuilder.repo.QuestionFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionFormService {
    private final QuestionFormRepo questionFormRepo;

    @Autowired
    public QuestionFormService(QuestionFormRepo questionFormRepo) {
        this.questionFormRepo = questionFormRepo;
    }

    public QuestionForm addQuestionForm(QuestionForm questionForm) {
        return questionFormRepo.save(questionForm);
    }

    public List<QuestionForm> findAllQuestionForm() {
        return questionFormRepo.findAll();
    }
}
