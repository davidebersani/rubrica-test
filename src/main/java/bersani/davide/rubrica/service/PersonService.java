package bersani.davide.rubrica.service;

import bersani.davide.rubrica.model.Person;
import bersani.davide.rubrica.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
