package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.constants.Messages;
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
		if (checkIfProgrammingLanguageNameExists(createProgrammingLanguageRequest.getName()) == false
				|| checkIfNameIsEmpty(createProgrammingLanguageRequest.getName()) == false) {
			return;
		}

		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setProgrammingLanguageName(createProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		if (checkIfId(deleteProgrammingLanguageRequest.getId()) == false) {
			return;
		}
		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		if (checkIfProgrammingLanguageNameExists(updateProgrammingLanguageRequest.getName()) == false
				|| checkIfNameIsEmpty(updateProgrammingLanguageRequest.getName()) == false
				|| checkIfId(updateProgrammingLanguageRequest.getId()) == false) {
			return;
		}
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
		if (checkIfId(id) == false) {
			return null;
		}
		ProgrammingLanguage language = programmingLanguageRepository.findById(id).get();
		GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
		response.setName(language.getProgrammingLanguageName());
		return response;
	}

	private boolean checkIfProgrammingLanguageNameExists(String name) {
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.getByProgrammingLanguageName(name);
		if (programmingLanguage != null) {
			System.out.println(Messages.PROGRAMMING_LANGUAGE_NAME_EXISTS + " : " + name);
			return false;
		}
		return true;
	}

	private boolean checkIfNameIsEmpty(String name) {
		if (name.equals("") || name.equals(null)) {
			System.out.println(Messages.PROGRAMMING_LANGUAGE_NAME_EMPTY);
			return false;
		}
		return true;
	}

	private boolean checkIfId(int id) {
		if (!this.programmingLanguageRepository.existsById(id)) {
			System.out.println(Messages.PROGRAMMING_LANGUAGE_NOT_FOUND);
			return false;
		}
		return true;
	}

}
