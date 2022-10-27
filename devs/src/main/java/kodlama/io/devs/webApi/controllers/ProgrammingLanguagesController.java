package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) {
		languageService.add(programmingLanguage);
	}

	@DeleteMapping("/delete")
	public void delete(int id) {
		languageService.delete(id);
	}
	
	@PostMapping("update")
	public void update(ProgrammingLanguage programmingLanguage) {
		languageService.update(programmingLanguage);
	}


	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		return languageService.getById(id);
	}

}
