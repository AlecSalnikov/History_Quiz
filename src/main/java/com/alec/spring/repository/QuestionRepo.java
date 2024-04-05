package com.alec.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alec.spring.models.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer>{
	
	Optional<Question> findByPhotoURL(String photoURL);
	
	Optional<Question> findById(int id);
}
 