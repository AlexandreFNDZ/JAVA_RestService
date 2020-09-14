package com.example.restgreeting;

import com.example.restgreeting.gateway.model.Person;
import com.example.restgreeting.model.PersonView;
import com.example.restgreeting.usecase.GetPeopleList;
import com.example.restgreeting.usecase.GetPersonById;
import com.example.restgreeting.usecase.SetPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v2")
public class PeopleController {

    private final GetPersonById getPersonById;
    private final GetPeopleList getPeopleList;
    private final SetPerson setPerson;

    @Autowired
    public PeopleController(final GetPersonById getPersonById, final GetPeopleList getPeopleList, final SetPerson setPerson) {
        this.getPersonById = getPersonById;
        this.getPeopleList = getPeopleList;
        this.setPerson = setPerson;
    }

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPeopleList() {
        return ResponseEntity.ok().body(this.getPeopleList.execute());
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") long id) {
        try {
            return ResponseEntity.ok().body(this.getPersonById.execute(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/people")
    public ResponseEntity<Person> setPerson(@RequestBody PersonView newPerson) {
        Person personCreated = this.setPerson.execute(newPerson);

        return ResponseEntity.ok().body(personCreated);
    }
}
