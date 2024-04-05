package com.alec.spring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Blob;
import com.alec.spring.models.Question;
import com.alec.spring.models.QuestionForm;
import com.alec.spring.models.Result;
import com.alec.spring.repository.QuestionRepo;
import com.alec.spring.service.QuestionService;
import com.alec.spring.service.QuestionServiceImpl;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller

public class MainController {
	@Autowired
	Result result;
	@Autowired
	QuestionServiceImpl qService;
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired 
	private QuestionRepo questionRepo;
	Boolean submitted = false;
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}
	
	@GetMapping("/")
	public String home (Model model) {
		model.addAttribute("title", "Barukk");
		return "index";
	}
	
	//@GetMapping("/startTesting")
	//public String test(Model model) {
	
		
		
		//Iterable<Question> questions = questionRepo.findAll();
	//	model.addAttribute("questions",questions);
		
		
		//return "testing";
	//}
	
	//produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE}
	  @PostMapping(value = "/testing")
	  public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
			if(username.equals("")) {
				ra.addFlashAttribute("warning", "You must enter your name");
				return "redirect:/";
			}
			
			submitted = false;
			result.setUsername(username);
			QuestionForm qForm = qService.getQuestions();
		
		
			m.addAttribute("qForm", qForm);
			
			return "testing";
			 
			
			
			
		}
	    
	
	
	  @GetMapping("/score")
		public String score(Model m) {
			List<Result> sList = qService.getTopScore();
			m.addAttribute("sList", sList);
			
			return "scoreboard";}
	
	
			@PostMapping("/submit")
			public String submit(@ModelAttribute QuestionForm qForm, Model m) {
				if(!submitted) {
					
					result.setTotalCorrect(qService.getResult(qForm));
					qService.saveScore(result);}
				
					submitted=true;	
					return "result";
}}
