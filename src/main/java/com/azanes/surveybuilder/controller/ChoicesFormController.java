package com.azanes.surveybuilder.controller;

import com.azanes.surveybuilder.model.ChoicesForm;
import com.azanes.surveybuilder.service.ChoicesFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/choicesforms")
public class ChoicesFormController {
    private final ChoicesFormService choicesFormService;

    @Autowired
    public ChoicesFormController(ChoicesFormService choicesFormService) {
        this.choicesFormService = choicesFormService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChoicesForm>> findAllChoicesForm() {
        List<ChoicesForm> choicesForms = choicesFormService.findAllChoicesForm();
        return new ResponseEntity<>(choicesForms, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ChoicesForm> addChoicesForm(@RequestBody ChoicesForm choicesForm) {
        ChoicesForm newChoicesForm = choicesFormService.addChoicesForm(choicesForm);
        return new ResponseEntity<>(newChoicesForm, HttpStatus.OK);
    }
}
