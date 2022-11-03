package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);

	List<GetAllProgrammingLanguageResponse> getAll();

	GetByIdProgrammingLanguageResponse getById(int id);

}
