package com.alec.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alec.spring.models.Question;
import com.alec.spring.models.QuestionForm;
import com.alec.spring.models.Result;
import com.alec.spring.repository.QuestionRepo;
import com.alec.spring.repository.ResultRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepo questionRepo;
	@Autowired
	Question question;
	@Autowired
	QuestionForm qForm;
	@Autowired
	Result result;
	@Autowired
	ResultRepo rRepo;
	
	
	public QuestionForm getQuestions() {
		List<Question> allQues = questionRepo.findAll();
		List<Question> qList = new ArrayList<Question>();
		
		Random random = new Random();
		
		for(int i=0; i<4; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}

		qForm.setQuestions(qList);
		
		return qForm;
	}


	
		
	


	

	public int getResult(QuestionForm qForm) {
		int correct = 0;
		
		for(Question q: qForm.getQuestions())
			if(q.getAns() == q.getChose())
				correct++;
		
		return correct;
	}
	
	public void saveScore(Result result) {
		Result saveResult = new Result();
		saveResult.setUsername(result.getUsername());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}
	
	public List<Result> getTopScore() {
		List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
		
		return sList;
	}
}
	





