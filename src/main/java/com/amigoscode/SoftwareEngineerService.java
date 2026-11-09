package com.amigoscode;

import java.nio.channels.IllegalSelectorException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SoftwareEngineerService {
	private final SoftwareEngineerRepository repository;
	private final AiService aiService;

	
	public SoftwareEngineerService(SoftwareEngineerRepository repository, AiService aiService) {
		super();
		this.repository = repository;
		this.aiService = aiService;
	}

	public List<SoftwareEngineer> getAllSoftwareEngineer()
	{
		return repository.findAll();
	}

	public void insertEngineer(SoftwareEngineer eng)
	{
		String prompt = """
				Based on the programming tech stack %s that %s has given
				Provide a full learning path and recommendation for this person.
				""".formatted(eng.getTechStack(), eng.getName());
		String chatRes = aiService.chat(prompt);
		eng.setLearningPathRecommendation(chatRes);
		repository.save(eng);
	}
	
	public SoftwareEngineer getEngineerById(Integer id)
	{
		return repository.findById(id).orElseThrow(()-> new IllegalStateException(id + " not found"));
	}
	
	public void deleteEngineerById(Integer id)
	{
		boolean exists = repository.existsById(id);
		if(!exists) {
			throw new IllegalStateException((id + " not found"));
		}
		repository.deleteById(id);
	}
	
	public void updateEngineer(SoftwareEngineer data)
	{
		boolean exists = repository.existsById(data.getId());
		if(exists) {
			repository.save(data);
		}
		else
		{
			throw new IllegalStateException((data.getId() + " not found"));
		}
	}
}
