package com.tutorial.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.spring.model.Tutorial;

@Service
public interface TutorialService {

	public List<Tutorial> getAllTutorials(String title);
	public Tutorial createTutorial(Tutorial tutorial);
	public Tutorial updateTutorial(long id,Tutorial tutorial);
	public void deleteTutorial(long id);
}
