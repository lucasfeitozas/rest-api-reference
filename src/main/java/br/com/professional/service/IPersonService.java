package br.com.professional.service;

import java.util.List;

import br.com.professional.model.dto.PersonDTO;

public interface IPersonService {

	List<PersonDTO> findAll();

	PersonDTO save(PersonDTO person);
}
