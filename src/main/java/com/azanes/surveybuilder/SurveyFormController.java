package com.azanes.surveybuilder;

import com.azanes.surveybuilder.model.SurveyForm;
import com.azanes.surveybuilder.service.SurveyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveyforms")
public class SurveyFormController {
    private final SurveyFormService surveyFormService;

    @Autowired
    public SurveyFormController(SurveyFormService surveyFormService) {
        this.surveyFormService = surveyFormService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SurveyForm>> findAllSurveyForm() {
        List<SurveyForm> surveyForms = surveyFormService.findAllSurveyForm();
        return new ResponseEntity<>(surveyForms, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SurveyForm> findSurveyFormById(@PathVariable("id") Long id){
        SurveyForm surveyForm = surveyFormService.findSurveyFormById(id);
        return new ResponseEntity<>(surveyForm, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SurveyForm> addSurveyForm(@RequestBody SurveyForm surveyForm) {
        SurveyForm newSurveyForm = surveyFormService.addSurveyForm(surveyForm);
        return new ResponseEntity<>(newSurveyForm, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SurveyForm> updateSurveyForm(@RequestBody SurveyForm surveyForm) {
        SurveyForm updateSurveyForm = surveyFormService.updateSurveyForm(surveyForm);
        return new ResponseEntity<>(updateSurveyForm, HttpStatus.OK);
    }
}
