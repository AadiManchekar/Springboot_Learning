package com.aadi.quizapp.dao;

import org.springframework.stereotype.Repository;
import com.aadi.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

}
