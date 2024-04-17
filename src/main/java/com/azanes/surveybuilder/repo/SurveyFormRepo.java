package com.azanes.surveybuilder.repo;


import com.azanes.surveybuilder.model.SurveyForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyFormRepo extends JpaRepository<SurveyForm, Long> {

    Optional<SurveyForm> findSurveyFormById(Long id);
}

