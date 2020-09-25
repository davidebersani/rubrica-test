package bersani.davide.rubrica.repository;

import bersani.davide.rubrica.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();
}
