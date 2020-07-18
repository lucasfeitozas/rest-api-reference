package br.com.professional.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.professional.mapper.SimpleSourceDestinationPersonMapper;
import br.com.professional.model.Person;
import br.com.professional.model.dto.PersonDTO;
import br.com.professional.repository.PersonRepository;
import br.com.professional.service.IPersonService;

@Service
public class PersonService implements IPersonService {

	private SimpleSourceDestinationPersonMapper mapper = Mappers.getMapper(SimpleSourceDestinationPersonMapper.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<PersonDTO> findAll() {

		List<Person> persons = personRepository.findAll();
		
		return persons.stream()
				.map(item -> mapper.sourceToDestination(item))
				.collect(Collectors.toList());
	}

	@Override
	public PersonDTO save(PersonDTO personDTO) {
		Person person = mapper.destinationToSource(personDTO);
		
		if (person == null)
			throw new NullPointerException("Person is null");
		
		Person personSaved = personRepository.save(person);
		
		return mapper.sourceToDestination(personSaved);
	}

}
