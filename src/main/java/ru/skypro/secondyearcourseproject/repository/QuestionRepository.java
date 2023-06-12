package ru.skypro.secondyearcourseproject.repository;

import ru.skypro.secondyearcourseproject.entity.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();
}
