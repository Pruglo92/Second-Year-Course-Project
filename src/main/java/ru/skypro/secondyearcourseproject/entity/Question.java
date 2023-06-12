package ru.skypro.secondyearcourseproject.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Getter
public class Question {
    private String question;
    private String answer;
}
