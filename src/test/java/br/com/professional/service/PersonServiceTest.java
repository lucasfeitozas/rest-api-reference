package br.com.professional.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.professional.model.dto.PersonDTO;

@SpringBootTest
public class PersonServiceTest {

	@Autowired
	private IPersonService personService;
	
	@Test
	public void shouldReturnAllItensOrEmptyList() {
		List<PersonDTO> persons = personService.findAll();
		
		assertTrue(persons != null);
	}
}
