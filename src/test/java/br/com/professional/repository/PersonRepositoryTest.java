package br.com.professional.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.professional.model.Person;

@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void wouldReturnAllPersons() {
		List<Person> findAll = personRepository.findAll();
		System.out.println(findAll);
		assertTrue(findAll != null);
	}
	
	@Test
	public void shouldSavePerson () { 
		Person person = new Person();
		person.setName("Maria");
		person.setAge(28);
		Person save = personRepository.save(person);
		
		assertTrue(save.getId() != null);
	}
}
