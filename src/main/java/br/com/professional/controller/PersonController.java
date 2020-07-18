package br.com.professional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.professional.model.dto.PersonDTO;
import br.com.professional.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// consulta: http://www.ciceroednilson.com.br/spring-boot-e-swagger-documentando-e-testando-a-sua-api-rest/
// consult: https://medium.com/@raphaelbluteau/spring-boot-swagger-documentando-sua-api-automaticamente-27903293aeb6
// ver link swagger: http://localhost:8080/swagger-ui.html#/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/persons")
@Api("Person")
public class PersonController {

	@Autowired
	private IPersonService personService;

	@ApiOperation(value = "Create a new person", response = ResponseEntity.class, notes = "Essa operação salva um novo registro de Pessoa")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retorna uma nova pessoa", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "Caso tenhamos algum erro vamos retornar um codigo de erro com a Exception", response = ResponseEntity.class)

	})
	@PostMapping
	public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO person) {

		final PersonDTO personSaved = personService.save(person);
		HttpStatus status = (personSaved != null) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).body(personSaved);
	}

	@GetMapping
	public List<PersonDTO> findAll() {
		return personService.findAll();
	}
}
