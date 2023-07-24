package com.aadi.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadi.quizapp.dao.QuestionDao;
import com.aadi.quizapp.model.Question;

@Service
public class QuestionService {

    private Integer generateQuestionId() {
        // Logic to generate a unique ID for the question
        // You can use a random generator, timestamp, or any other mechanism to generate
        // the ID
        // For this example, let's generate a random integer between 1 and 1000
        return (int) (Math.random() * 1000) + 1;
    }

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        if (question.getId() == null) {
            // Generate an ID for the question
            question.setId(generateQuestionId());
        }

        questionDao.save(question);
        return "Success";
    }

}
