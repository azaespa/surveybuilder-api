package com.azanes.surveybuilder.service;

import com.azanes.surveybuilder.exception.QuestionFormNotFoundException;
import com.azanes.surveybuilder.model.QuestionForm;
import com.azanes.surveybuilder.model.SurveyForm;
import com.azanes.surveybuilder.repo.QuestionFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionFormService {
    private final QuestionFormRepo questionFormRepo;

    @Autowired
    public QuestionFormService(QuestionFormRepo questionFormRepo) {
        this.questionFormRepo = questionFormRepo;
    }

    public QuestionForm addQuestionForm(SurveyForm surveyForm, QuestionForm questionForm) {
        questionForm.setSurveyForm(surveyForm);
        return questionFormRepo.save(questionForm);
    }

    public List<QuestionForm> findAllQuestionForm() {
        return questionFormRepo.findAll();
    }

    public List<QuestionForm> findAllQuestionFormBySfId(Long id){
        return questionFormRepo.findAllBySurveyFormId(id)
                .orElseThrow(() -> new QuestionFormNotFoundException("QuestionForm " + id + " is not found."));
    }

    public QuestionForm findQuestionFormById(Long id) {
        return questionFormRepo.findQuestionFormById(id)
                .orElseThrow(() -> new QuestionFormNotFoundException("QuestionForm " + id + " is not found."));
    }

    public QuestionForm updateQuestionForm(QuestionForm questionForm) {
        return questionFormRepo.save(questionForm);
    }
}
