package ru.skypro.secondyearcourseproject.repository.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.repository.QuestionRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> mathQuestions = new HashSet<>();

    @Override
    public Question add(Question question) {
        if (mathQuestions.add(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Question remove(String question, String answer) {
        var mathQuestion = new Question(question, answer);
        if (mathQuestions.remove(mathQuestion)) {
            return mathQuestion;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(mathQuestions);
    }

    @PostConstruct
    private void init() {
        mathQuestions.add(new Question("Математика1", "Математика1"));
        mathQuestions.add(new Question("Математика2", "Математика2"));
        mathQuestions.add(new Question("Математика3", "Математика3"));
        mathQuestions.add(new Question("Математика4", "Математика4"));
        mathQuestions.add(new Question("Математика5", "Математика5"));
    }
}
