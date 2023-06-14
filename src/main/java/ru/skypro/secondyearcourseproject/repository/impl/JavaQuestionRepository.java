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
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> javaQuestions = new HashSet<>();

    @Override
    public Question add(Question question) {
        if (javaQuestions.add(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Question remove(String question, String answer) {
        var javaQuestion = new Question(question, answer);
        if (javaQuestions.remove(javaQuestion)) {
            return javaQuestion;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(javaQuestions);
    }

    @PostConstruct
    private void init() {
        javaQuestions.add(new Question("Джава1", "Джава1"));
        javaQuestions.add(new Question("Джава2", "Джава2"));
        javaQuestions.add(new Question("Джава3", "Джава3"));
        javaQuestions.add(new Question("Джава4", "Джава4"));
        javaQuestions.add(new Question("Джава5", "Джава5"));
    }
}
