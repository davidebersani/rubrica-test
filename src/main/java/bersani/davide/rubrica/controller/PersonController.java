package bersani.davide.rubrica.controller;

import bersani.davide.rubrica.model.Person;
import bersani.davide.rubrica.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
