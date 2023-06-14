package ru.skypro.secondyearcourseproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.exceptions.WrongAmountException;
import ru.skypro.secondyearcourseproject.service.ExaminerService;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    @Override
    public Collection<Question> getQuestions(final Integer amount) {
        Random random = new Random();
        if (amount == 0) {
            throw new WrongAmountException("Количество запросов не может быть 0");
        }

        var javaQuestions = javaQuestionService.getAll();
        var mathQuestions = mathQuestionService.getAll();
        if (amount > (javaQuestions.size() + mathQuestions.size())) {
            throw new WrongAmountException("Отсутствует данное количество запросов");
        }

        return Stream.generate(() -> {
                    if (javaQuestions.size() == 0 && mathQuestions.size() != 0) {
                        return mathQuestionService.getRandomQuestion();
                    } else if (javaQuestions.size() != 0 && mathQuestions.size() == 0) {
                        return javaQuestionService.getRandomQuestion();
                    } else {
                        return random.nextBoolean()
                                ? javaQuestionService.getRandomQuestion()
                                : mathQuestionService.getRandomQuestion();
                    }
                })
                .distinct()
                .limit(amount)
                .collect(Collectors.toSet());
    }
}
//      и зачем нам вызов метода getRandomQuestion()...:)
//    @Override
//    public Collection<Question> getQuestions(final Integer amount) {
//        if (amount == 0) {
//            throw new WrongAmountException("Неверное количество запросов");
//        }
//        var javaQuestions = javaQuestionService.getAll();
//        var mathQuestions = mathQuestionService.getAll();
//        if (amount > (javaQuestions.size() + mathQuestions.size())) {
//            throw new WrongAmountException("Неверное количество запросов");
//        }
//        return Stream.concat(javaQuestions.stream(), mathQuestions.stream())
//                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
//                    Collections.shuffle(list, new Random());
//                    return list.stream().limit(amount).collect(Collectors.toList());
//                }));
//    }
//}

