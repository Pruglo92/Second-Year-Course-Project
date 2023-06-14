package ru.skypro.secondyearcourseproject.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.repository.impl.MathQuestionRepository;
import ru.skypro.secondyearcourseproject.service.impl.MathQuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    private MathQuestionService mathQuestionService;

    private String question;
    private String answer;
    private List<Question> mockQuestions;

    @BeforeEach
    public void setup() {
        question = "What is 2 + 2?";
        answer = "4";
        mockQuestions = new ArrayList<>();
        mockQuestions.add(new Question(question, answer));
        mockQuestions.add(new Question("What is 5 - 3?", "2"));
        mockQuestions.add(new Question("What is 10 * 2?", "20"));
    }

    @Test
    @DisplayName("Тест на добавление с полями")
    public void testAddMathQuestionWithQuestionAndAnswer() {

        when(mathQuestionRepository.add(any(Question.class))).thenReturn(mockQuestions.get(0));

        Question result = mathQuestionService.add(question, answer);

        verify(mathQuestionRepository, times(1)).add(mockQuestions.get(0));
        assertEquals(mockQuestions.get(0), result);
    }

    @Test
    @DisplayName("Тест на добавление с сущностью")
    public void testAddMathQuestionWithQuestion() {

        when(mathQuestionRepository.add(any(Question.class))).thenReturn(mockQuestions.get(0));

        Question result = mathQuestionService.add(mockQuestions.get(0));

        verify(mathQuestionRepository, times(1)).add(mockQuestions.get(0));
        assertEquals(mockQuestions.get(0), result);
    }

    @Test
    @DisplayName("Тест на удаление")
    public void testRemoveMathQuestion() {

        when(mathQuestionRepository.remove(question, answer)).thenReturn(mockQuestions.get(0));

        Question result = mathQuestionService.remove(question, answer);

        verify(mathQuestionRepository, times(1)).remove(question, answer);
        assertEquals(mockQuestions.get(0), result);
    }

    @Test
    @DisplayName("Тест на получение всех вопросов")
    public void testGetAllMathQuestions() {

        when(mathQuestionRepository.getAll()).thenReturn(mockQuestions);

        Collection<Question> result = mathQuestionService.getAll();

        verify(mathQuestionRepository, times(1)).getAll();
        assertEquals(mockQuestions, result);
    }

    @Test
    @DisplayName("Тест на получение случайного вопроса")
    public void testGetRandomQuestion() {

        when(mathQuestionRepository.getAll()).thenReturn(mockQuestions);

        Question result = mathQuestionService.getRandomQuestion();

        Optional<Question> expectedQuestion = mockQuestions.stream().filter(q -> q.equals(result)).findFirst();
        assertEquals(expectedQuestion.orElse(null), result);
        verify(mathQuestionRepository, times(2)).getAll();
    }
}
