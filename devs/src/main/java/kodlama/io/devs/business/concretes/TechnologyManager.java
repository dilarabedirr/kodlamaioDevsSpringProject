package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import kodlama.io.devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRespository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		this.technologyRepository = technologyRespository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setTechnologyName(createTechnologyRequest.getName());
		technology.setProgrammingLanguage(
				programmingLanguageRepository.getById(createTechnologyRequest.getProgrammingLanguageId()));
		technologyRepository.save(technology);

	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyRepository.deleteById(deleteTechnologyRequest.getId());

	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = new Technology();
		technology.setTechnologyId(updateTechnologyRequest.getId());
		technology.setTechnologyName(updateTechnologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguageRepository.getById(updateTechnologyRequest.getProgrammingLanguageId()));
		technologyRepository.save(technology);

	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponses = new ArrayList<GetAllTechnologyResponse>();

		for (Technology technology : technologies) {
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			response.setName(technology.getTechnologyName());

			technologyResponses.add(response);
		}
		return technologyResponses;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Technology technology = technologyRepository.findById(id).get();
		GetByIdTechnologyResponse response = new GetByIdTechnologyResponse();
		response.setName(technology.getTechnologyName());
		response.setId(technology.getTechnologyId());
		return response;
	}

}
