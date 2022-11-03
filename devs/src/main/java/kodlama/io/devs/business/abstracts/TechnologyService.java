package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import kodlama.io.devs.business.responses.technologyResponses.GetByIdTechnologyResponse;


public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest);

	void delete(DeleteTechnologyRequest deleteTechnologyRequest);

	void update(UpdateTechnologyRequest updateTechnologyRequest);

	List<GetAllTechnologyResponse> getAll();

	GetByIdTechnologyResponse getById(int id);
}
