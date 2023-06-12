package ru.skypro.secondyearcourseproject.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.repository.impl.JavaQuestionRepository;
import ru.skypro.secondyearcourseproject.repository.impl.MathQuestionRepository;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionRepositoryTest {
    @InjectMocks
    private MathQuestionRepository repository;
    private Question question;

    @BeforeEach
    void setUp() {
        question = new Question("Question 1", "Answer 1");
        repository.add(new Question("Question 2", "Answer 2"));
        repository.add(new Question("Question 3", "Answer 3"));
    }

    @Test
    @DisplayName("Тест на добавление вопроса")
    void testAdd() {

        Question addedQuestion = repository.add(question);

        assertEquals(question, addedQuestion);
    }

    @Test
    @DisplayName("Тест на удаление вопроса")
    void testRemove() {

        repository.add(question);

        Question removedQuestion = repository.remove(question.getQuestion(), question.getAnswer());

        assertEquals(question, removedQuestion);
    }

    @Test
    @DisplayName("Тест на получение всех вопросов")
    void testGetAll() {

        Collection<Question> allQuestions = repository.getAll();

        assertEquals(2, allQuestions.size());
    }
}
