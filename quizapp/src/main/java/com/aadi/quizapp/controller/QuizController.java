package com.aadi.quizapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numOfQuestions,
            @RequestParam String title) {

        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

}
