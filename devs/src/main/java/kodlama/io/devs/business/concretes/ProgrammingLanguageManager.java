package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		var languages = programmingLanguageRepository.findAll();
		for (ProgrammingLanguage language : languages) {
			if (createProgrammingLanguageRequest.getName().equals(language.getProgrammingLanguageName())) {
				System.out.println("İsim tekrar edemez : " + createProgrammingLanguageRequest.getName());
				return;
			}
		}
		if (createProgrammingLanguageRequest.getName() == "" || createProgrammingLanguageRequest.getName() == null) {
			System.out.println("Programlama dili boş geçilemez.");
			return;
		}
		ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
		programmingLanguage.setProgrammingLanguageName(createProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
	    programmingLanguage.setProgrammingLanguageId(updateProgrammingLanguageRequest.getId());
	    programmingLanguage.setProgrammingLanguageName(updateProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> languageResponses = new ArrayList<GetAllProgrammingLanguageResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
			response.setId(programmingLanguage.getProgrammingLanguageId());
			response.setName(programmingLanguage.getProgrammingLanguageName());

			languageResponses.add(response);
		}
		return languageResponses;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage language = programmingLanguageRepository.findById(id).get();
		GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
		response.setName(language.getProgrammingLanguageName());
		return response;
	}

}
