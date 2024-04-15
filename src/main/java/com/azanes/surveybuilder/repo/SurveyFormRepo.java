package com.azanes.surveybuilder.repo;


import com.azanes.surveybuilder.model.SurveyForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyFormRepo extends JpaRepository<SurveyForm, Long> {

}
