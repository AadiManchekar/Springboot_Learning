package com.aadi.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadi.quizapp.model.Question;
import com.aadi.quizapp.service.QuestionService;

@RestController
@RequestMapping("v1/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
