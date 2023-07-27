package com.aadi.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aadi.quizapp.model.Quiz;
import com.aadi.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping
    public List<Quiz> getQuiz() {
        return quizService.getQuiz();
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numOfQuestions,
            @RequestParam String title) {

        return quizService.createQuiz(category, numOfQuestions, title);
    }

}
