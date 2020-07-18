package br.com.professional.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.professional.model.Person;
import br.com.professional.model.dto.PersonDTO;

// reference https://www.baeldung.com/mapstruct
//@Mapper
@Mapper//(componentModel = "spring")
public interface SimpleSourceDestinationPersonMapper {

	SimpleSourceDestinationPersonMapper INSTANCE = Mappers.getMapper(SimpleSourceDestinationPersonMapper.class);
	
	PersonDTO sourceToDestination(Person source);

	Person destinationToSource(PersonDTO destination);
}
