package br.com.professional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.professional.model.Person;

/**
 * @author lucasfeitozas
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
