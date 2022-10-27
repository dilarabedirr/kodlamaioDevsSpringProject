package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
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
	public void add(ProgrammingLanguage programmingLanguage) {
		var languages = programmingLanguageRepository.getAll();
		for (ProgrammingLanguage language : languages) {
			if (programmingLanguage.getName().equals(language.getName())) {
				System.out.println("İsim tekrar edemez : " + programmingLanguage.getName());
				return;
			}
		}
		if (programmingLanguage.getName() == "" || programmingLanguage.getName() == null) {
			System.out.println("Programlama dili boş geçilemez.");
			return;
		}
		programmingLanguageRepository.add(programmingLanguage);

	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.update(programmingLanguage);

	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

}
