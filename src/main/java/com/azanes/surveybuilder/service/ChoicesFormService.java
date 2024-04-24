package com.azanes.surveybuilder.service;

import com.azanes.surveybuilder.model.ChoicesForm;
import com.azanes.surveybuilder.repo.ChoicesFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoicesFormService {
    private final ChoicesFormRepo choicesFormRepo;

    @Autowired
    public ChoicesFormService(ChoicesFormRepo choicesFormRepo) {
        this.choicesFormRepo = choicesFormRepo;
    }

    public List<ChoicesForm> findAllChoicesForm() {
        return choicesFormRepo.findAll();
    }

    public ChoicesForm addChoicesForm(ChoicesForm choicesForm) {
        return choicesFormRepo.save(choicesForm);
    }
}
