package com.aadi.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<List<Question>>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Question>>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<List<Question>>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Question>>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        // if (question.getId() == null) {
        // // Generate an ID for the question
        // question.setId(generateQuestionId());
        // }

        // questionDao.save(question);
        // return new ResponseEntity<String>("Success", HttpStatus.CREATED);
        try {
            if (question.getId() == null) {
                // Generate an ID for the question
                question.setId(generateQuestionId());
            }

            questionDao.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: Could not add the question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
