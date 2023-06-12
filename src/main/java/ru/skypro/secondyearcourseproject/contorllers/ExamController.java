package ru.skypro.secondyearcourseproject.contorllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.secondyearcourseproject.entity.Question;
import ru.skypro.secondyearcourseproject.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExaminerService examinerService;

    @GetMapping("/get/{amount}")
    public ResponseEntity<Collection<Question>> getQuestions(@PathVariable Integer amount) {
        return ResponseEntity.ok(examinerService.getQuestions(amount));
    }
}
