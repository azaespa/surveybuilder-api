package com.azanes.surveybuilder.service;

import com.azanes.surveybuilder.exception.SurveyFormNotFoundException;
import com.azanes.surveybuilder.model.QuestionForm;
import com.azanes.surveybuilder.model.SurveyForm;
import com.azanes.surveybuilder.repo.SurveyFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
        surveyForm.setSurveyFormId(UUID.randomUUID().toString());
        surveyForm.setSurveyFormName("My Default Form Name");
        return surveyFormRepo.save(surveyForm);
    }

    public List<SurveyForm> findAllSurveyForm() {
        return surveyFormRepo.findAll();
    }

    public SurveyForm findSurveyFormById(Long id){
        return surveyFormRepo.findSurveyFormById(id)
                .orElseThrow(() -> new SurveyFormNotFoundException("SurveyForm " + id + " is not found"));
    }

    public SurveyForm updateSurveyForm(SurveyForm surveyForm) {
        return surveyFormRepo.save(surveyForm);
    }
}
