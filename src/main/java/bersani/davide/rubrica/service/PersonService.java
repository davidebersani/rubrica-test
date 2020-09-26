package bersani.davide.rubrica.service;

import bersani.davide.rubrica.model.Person;
import bersani.davide.rubrica.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        Optional<Person> p = personRepository.findById(id);
        if(p.isEmpty())
            throw new IllegalArgumentException("Person not found");

        return p.get();
    }
}
