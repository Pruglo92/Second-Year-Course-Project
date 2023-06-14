package ru.skypro.secondyearcourseproject.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.exceptions.WrongAmountException;
import ru.skypro.secondyearcourseproject.service.impl.ExaminerServiceImpl;
import ru.skypro.secondyearcourseproject.service.impl.JavaQuestionService;
import ru.skypro.secondyearcourseproject.service.impl.MathQuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    private List<Question> javaQuestions;
    private List<Question> mathQuestions;

    @BeforeEach
    public void setup() {
        javaQuestions = new ArrayList<>();
        mathQuestions = new ArrayList<>();
        javaQuestions.add(new Question("Java Question 1", "Answer 1"));
        javaQuestions.add(new Question("Java Question 2", "Answer 2"));
        mathQuestions.add(new Question("Math Question 1", "Answer 1"));
        mathQuestions.add(new Question("Math Question 2", "Answer 2"));
    }

    @Test
    @DisplayName("Тест на получение случайных вопросов")
    public void testGetQuestions() {

        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(javaQuestions.get(0)).thenReturn(javaQuestions.get(1));
        when(mathQuestionService.getRandomQuestion()).thenReturn(mathQuestions.get(0)).thenReturn(mathQuestions.get(1));

        Collection<Question> result = examinerService.getQuestions(3);

        assertEquals(3, result.size());
        assertTrue(result.contains(javaQuestions.get(0)) ||
                result.contains(javaQuestions.get(1)));
        assertTrue(result.contains(mathQuestions.get(0)) ||
                result.contains(mathQuestions.get(1)));
    }

    @Test
    @DisplayName("Тест на выбрасывание ошибки при нулевом запросе")
    void testGetQuestionsWithZeroAmount() {
        assertThrows(WrongAmountException.class, () ->
                examinerService.getQuestions(0)
        );
    }

    @Test
    @DisplayName("Тест на выбрасывание ошибки при преувеличении количества запросов")
    void testGetQuestionsWithInvalidAmount() {

        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);

        assertThrows(WrongAmountException.class, () ->
                examinerService.getQuestions(5)
        );
    }
}
