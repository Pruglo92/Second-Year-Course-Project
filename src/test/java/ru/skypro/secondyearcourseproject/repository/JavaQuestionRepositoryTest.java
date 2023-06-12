package ru.skypro.secondyearcourseproject.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.repository.impl.JavaQuestionRepository;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionRepositoryTest {
    @InjectMocks
    private JavaQuestionRepository repository;
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
