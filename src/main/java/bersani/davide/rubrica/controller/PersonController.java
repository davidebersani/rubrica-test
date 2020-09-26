package bersani.davide.rubrica.controller;

import bersani.davide.rubrica.model.Person;
import bersani.davide.rubrica.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String home(Model model) {
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("persons",allPersons);
        return "index";
    }

    @GetMapping("/confirmDelete")
    public String confirmDelete(@RequestParam(name="id", required=true) Long id, Model model) {
        Person p = personService.getPersonById(id);
        model.addAttribute("person",p);
        return "confirmDelete";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name="id", required=true) Long id, Model model) {
        personService.deletePerson(id);
        model.addAttribute("message","Persona eliminata.");
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("persons",allPersons);
        return "index";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person",new Person());
        return "newPerson";
    }

    @PostMapping("/addPerson")
    public String addPerson(Model model, @ModelAttribute("person")Person person) {
        Person p = personService.addPerson(person);
        String message;
        if(p.getId()!=null)
            message = "Nuova persona aggiunta correttamente.";
        else
            message = "Errore nell'aggiunta della nuova persona.";

        model.addAttribute("message",message);
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("persons",allPersons);
        return "index";
    }
}
