package com.tutorial.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.spring.model.Tutorial;
import com.tutorial.spring.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	TutorialRepository tutorialRepository;
	
	@Override
	public List<Tutorial> getAllTutorials(String title) {	
			List<Tutorial> tutorials = new ArrayList<Tutorial>();
			if (title == null)
				tutorialRepository.findAll().forEach(tutorials::add);
			else
				tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);			
			return tutorials;	
	}

	@Override
	public Tutorial createTutorial(Tutorial tutorial) {
		Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
		return _tutorial;
	}

	@Override
	public Tutorial updateTutorial(long id, Tutorial tutorial) {
		// TODO Auto-generated method stub
		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
		Tutorial _tutorial = new Tutorial();
		if (tutorialData.isPresent()) {
			_tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());
			tutorialRepository.save(_tutorial);
		}
		return _tutorial;
	}

	@Override
	public void deleteTutorial(long id) {
		tutorialRepository.deleteById(id);
		
	}
}