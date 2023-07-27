package com.aadi.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aadi.quizapp.dao.QuestionDao;
import com.aadi.quizapp.dao.QuizDao;
import com.aadi.quizapp.model.Quiz;
import com.aadi.quizapp.model.Question;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, Integer numOfQuestions, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quiz.setNoOfQuestions(numOfQuestions);

        try {
            quizDao.save(quiz);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: Could not add the question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Quiz> getQuiz() {
        return quizDao.findAll();
    }

}
