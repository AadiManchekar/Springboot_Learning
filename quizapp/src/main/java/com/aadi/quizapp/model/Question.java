package com.aadi.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @SequenceGenerator(name = "question_id_sequence", sequenceName = "question_id_sequence", allocationSize = 1, initialValue = 21)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_sequence")
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
