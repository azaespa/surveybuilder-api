package com.azanes.surveybuilder.service;

import com.azanes.surveybuilder.model.SurveyForm;
import com.azanes.surveybuilder.repo.SurveyFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SurveyFormService {
    private final SurveyFormRepo surveyFormRepo;

    @Autowired
    public SurveyFormService(SurveyFormRepo surveyFormRepo) {
        this.surveyFormRepo = surveyFormRepo;
    }

    public SurveyForm addSurveyForm(SurveyForm surveyForm) {
        surveyForm.setSurveyId(UUID.randomUUID().toString());
        return surveyFormRepo.save(surveyForm);
    }

    public List<SurveyForm> findAllSurveyForm() {
        return surveyFormRepo.findAll();
    }
}
