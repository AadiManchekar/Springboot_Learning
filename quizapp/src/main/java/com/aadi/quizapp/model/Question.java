package com.aadi.quizapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor // Add this annotation to generate a default constructor
@Entity
public class Question {

    @Id
    @SequenceGenerator(name = "question_id_sequence", sequenceName = "question_id_sequence", allocationSize = 1, initialValue = 21)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_sequence")
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String questionTitle;

    @NonNull
    @Column(nullable = false)
    private String option1;

    @NonNull
    @Column(nullable = false)
    private String option2;

    @NonNull
    @Column(nullable = false)
    private String option3;

    @NonNull
    @Column(nullable = false)
    private String option4;

    @NonNull
    @Column(nullable = false)
    private String rightAnswer;

    @NonNull
    @Column(nullable = false)
    private String difficultyLevel;

    @NonNull
    @Column(nullable = false)
    private String category;
}
