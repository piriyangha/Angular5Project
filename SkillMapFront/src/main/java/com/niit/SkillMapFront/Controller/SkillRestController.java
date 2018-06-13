package com.niit.SkillMapFront.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SkillMapBackend.model.Employee;
import com.niit.SkillMapBackend.model.Skills;
import com.niit.SkillMapBackend.service.SkillServiceDao;

@RestController
@RequestMapping("/api/rest/skills")
@CrossOrigin(origins="http://localhost:4200")
public class SkillRestController {
	@Autowired
	SkillServiceDao skillService;
	
	@GetMapping
	public ResponseEntity<List<Skills>> listOfSkills(){
		List<Skills> skilllist=skillService.retriveSkillService();
		if(skilllist.isEmpty())
			return new ResponseEntity<List<Skills>>(skilllist,HttpStatus.EXPECTATION_FAILED);
		else
			return new ResponseEntity<List<Skills>>(skilllist,HttpStatus.OK); 
	}
	@PostMapping
	public ResponseEntity<Skills> addSkills(@RequestBody Skills skills){
		if (skillService.addSkillsService(skills))
			return new ResponseEntity<Skills>(HttpStatus.CREATED);
		else
			return new ResponseEntity<Skills>(HttpStatus.CONFLICT);
	}
	@PutMapping
	public ResponseEntity<Skills> updateSkills(@RequestBody Skills skills)
	{
		skillService.updateSkillsService(skills);
			return new ResponseEntity<Skills>(HttpStatus.OK);
	   
	}
	
}
