package com.aadi.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aadi.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

}