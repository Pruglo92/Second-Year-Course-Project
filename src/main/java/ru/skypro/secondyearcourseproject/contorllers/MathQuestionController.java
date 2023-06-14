package ru.skypro.secondyearcourseproject.contorllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class MathQuestionController {

    private final QuestionService mathQuestionService;

    @GetMapping("/math/add")
    public ResponseEntity<Question> addQuestion(@RequestParam String question,
                                                @RequestParam String answer) {
        return ResponseEntity.ok(mathQuestionService.add(question, answer));
    }

    @GetMapping("/math/remove")
    public ResponseEntity<Question> removeQuestion(@RequestParam String question,
                                                   @RequestParam String answer) {
        return ResponseEntity.ok(mathQuestionService.remove(question, answer));
    }

    @GetMapping("/math")
    public ResponseEntity<Collection<Question>> getAllQuestions() {
        return ResponseEntity.ok(mathQuestionService.getAll());
    }
}
