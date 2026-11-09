package com.amigoscode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
	
	private final SoftwareEngineerService service;
	
	
	
	public SoftwareEngineerController(SoftwareEngineerService service) {
		super();
		this.service = service;
	}



	@GetMapping
	public List<SoftwareEngineer> getEnginners(){
		/*return List.of(new SoftwareEngineer(1, "James", "js, node, react"),
				new SoftwareEngineer(2,"jamila","java, spring, spring boot"));*/

		Deque<String> pila = new ArrayDeque<>();
		
		
		
		Queue<Integer> prioridad = new PriorityQueue<>();
		
		Set<String> hashSet = new HashSet<>();
		Set<String> linkedHashSet = new LinkedHashSet<>();
		Set<String> treeSet = new TreeSet<>();
		
		Map<String, Integer> hashMap = new HashMap<>();

		
		

		hashSet.add("C"); hashSet.add("A"); hashSet.add("B"); hashSet.add("A");
		System.out.println(hashSet);       // orden no garantizado, sin duplicados
		
		

		
		
		
		
		return service.getAllSoftwareEngineer();
	}

	@PostMapping
	public void  addNewSoftwareEngineer(@RequestBody SoftwareEngineer eng)
	{
		service.insertEngineer(eng);
	}
	@GetMapping("{id}")
	public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
		System.out.println("param: "+id);
		return service.getEngineerById(id);
		
	}
	
	@DeleteMapping("{id}")
	public void deleteEngineerById(@PathVariable Integer id) {
		service.deleteEngineerById(id);
		
	}
	
	@PutMapping("{id}")
	public void updateEngineerById(@PathVariable Integer id, @RequestBody SoftwareEngineer eng) {
		eng.setId(id);
		service.updateEngineer(eng);
		
	}
}


