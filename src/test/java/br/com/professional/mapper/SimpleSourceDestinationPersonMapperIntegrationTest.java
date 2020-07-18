package br.com.professional.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import br.com.professional.model.Person;
import br.com.professional.model.dto.PersonDTO;

public class SimpleSourceDestinationPersonMapperIntegrationTest {

	private SimpleSourceDestinationPersonMapper mapper = Mappers.getMapper(SimpleSourceDestinationPersonMapper.class);
	
	@Test
	public void givenSourceToDestination_whenMaps_thenCorrect() {
		Person person = new Person();
		person.setId(1l);
		person.setName("John Doe");
		person.setAge(11);
		
		PersonDTO destination = mapper.sourceToDestination(person);
		
		assertEquals(person.getName(), destination.getName());
	}
	
	@Test
	public void givenDestinationToSource_whenMaps_thenCorrect() { 
		PersonDTO person = new PersonDTO();
		person.setId(1l);
		person.setName("John Doe");
		person.setAge(11);
		
		Person sourc = mapper.destinationToSource(person);
		
		assertEquals(person.getName(), sourc.getName());
	}
}
