package com.jd.demo.dao;

import com.jd.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where q.category=:category order by random() limit :numQ", nativeQuery = true)
    List<Question> findRamdomQuestionsByCategory(String category, int numQ);

    @Query(value = "select q.right_answer from question q where q.id=:id", nativeQuery = true)
    String findByRightAnswer(Integer id);
}
