package com.azanes.surveybuilder.controller;

import com.azanes.surveybuilder.model.QuestionForm;
import com.azanes.surveybuilder.model.SurveyForm;
import com.azanes.surveybuilder.service.QuestionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionforms")
public class QuestionFormController {
    private final QuestionFormService questionFormService;

    @Autowired
    public QuestionFormController(QuestionFormService questionFormService) {
        this.questionFormService = questionFormService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuestionForm>> findAllQuestionForm() {
        List<QuestionForm> questionForms = this.questionFormService.findAllQuestionForm();
        return new ResponseEntity<>(questionForms, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<QuestionForm> findQuestionFormById(@PathVariable("id") Long id){
        QuestionForm questionForm = questionFormService.findQuestionFormById(id);
        return new ResponseEntity<>(questionForm, HttpStatus.OK);
    }

    @GetMapping("/{surveyFormId}/all")
    public ResponseEntity<List<QuestionForm>> findAllQuestionFormBySfId(@PathVariable("surveyFormId") Long surveyFormId) {
        List<QuestionForm> questionForms = this.questionFormService.findAllQuestionFormBySfId(surveyFormId);
        return new ResponseEntity<>(questionForms, HttpStatus.OK);
    }

    @PostMapping("/{surveyFormId}/add")
    public ResponseEntity<QuestionForm> addQuestionForm(@PathVariable("surveyFormId") SurveyForm surveyForm, @RequestBody QuestionForm questionForm) {
        QuestionForm newQuestionForm = questionFormService.addQuestionForm(surveyForm ,questionForm);
        return new ResponseEntity<>(newQuestionForm, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<QuestionForm> updateQuestionForm(@RequestBody QuestionForm questionForm) {
        QuestionForm updateQuestionForm = questionFormService.updateQuestionForm(questionForm);
        return new ResponseEntity<>(updateQuestionForm, HttpStatus.OK);
    }
}
