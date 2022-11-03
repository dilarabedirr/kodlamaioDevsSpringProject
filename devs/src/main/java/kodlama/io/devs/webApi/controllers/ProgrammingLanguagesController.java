package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		languageService.add(createProgrammingLanguageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		languageService.delete(deleteProgrammingLanguageRequest);
	}

	@PutMapping("update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		languageService.update(updateProgrammingLanguageRequest);
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguageResponse> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdProgrammingLanguageResponse getById(int id) {
		return languageService.getById(id);
	}

}
