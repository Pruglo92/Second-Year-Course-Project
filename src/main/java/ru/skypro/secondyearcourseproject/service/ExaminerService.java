package ru.skypro.secondyearcourseproject.service;

import ru.skypro.secondyearcourseproject.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(Integer amount);
}
