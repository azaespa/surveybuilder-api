package com.azanes.surveybuilder.repo;

import com.azanes.surveybuilder.model.QuestionForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionFormRepo extends JpaRepository<QuestionForm, Long> {
}
