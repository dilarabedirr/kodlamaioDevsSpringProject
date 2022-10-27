package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	private List<ProgrammingLanguage> languages;

	public InMemoryProgrammingLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "C"));
		languages.add(new ProgrammingLanguage(3, "C++"));
		languages.add(new ProgrammingLanguage(4, "Kotlin"));
		languages.add(new ProgrammingLanguage(5, "Python"));
		languages.add(new ProgrammingLanguage(6, "Java"));
		languages.add(new ProgrammingLanguage(7, "PHP"));
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage);

	}

	@Override
	public void delete(int id) {
		languages.remove(getById(id));
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : languages) {
			if (language.getId() == programmingLanguage.getId()) {
				language.setName(programmingLanguage.getName());
			}
		}
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : languages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		return null;
	}

}
