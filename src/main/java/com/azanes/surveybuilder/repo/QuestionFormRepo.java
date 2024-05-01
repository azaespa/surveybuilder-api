package com.azanes.surveybuilder.repo;

import com.azanes.surveybuilder.model.QuestionForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionFormRepo extends JpaRepository<QuestionForm, Long> {
    Optional<QuestionForm> findQuestionFormById(Long id);

    Optional<List<QuestionForm>> findAllBySurveyFormId(Long id);
}
