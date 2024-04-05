package com.alec.spring.models;

import java.sql.Blob;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Component
@Entity
@Table(name = "QuizHist")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quesId;
	private String title;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;

	private String photoURL;
	private int ans;
	private int chose;
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

	public Question() {
		super();
	}



	public Question(int quesId, String title, String optionA, String optionB, String optionC, String optionD,
			String photoURL, int ans, int chose, byte[] image) {
		super();
		this.quesId = quesId;
		this.title = title;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.photoURL = photoURL;
		this.ans = ans;
		this.chose = chose;
		this.image = image;}



	public String getOptionD() {
		return optionD;
	}



	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}



	public String getPhotoURL() {
		return photoURL;
	}

	public byte[] getImage() {
		return image;}


	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public void setImage(byte[] image) {
		this.image = image;}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public int getChose() {
		return chose;
	}

	public void setChose(int choosed) {
		this.chose = choosed;
	}



	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", title=" + title + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", photoURL=" + photoURL + ", ans=" + ans
				+ ", chose=" + chose + "]";
	}
	 public String getImageDataBase64() {
	        return Base64.encodeBase64String(this.image);
	        
	        
	       
}}