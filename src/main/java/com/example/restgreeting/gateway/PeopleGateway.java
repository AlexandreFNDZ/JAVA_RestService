package com.example.restgreeting.gateway;

import com.example.restgreeting.gateway.model.Person;
import com.example.restgreeting.model.PersonView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class PeopleGateway {

    private final List<Person> peopleList;
    private final AtomicLong counter = new AtomicLong();

    public PeopleGateway() {
        this.peopleList = new ArrayList<>();
        this.peopleList.add(new Person(counter.incrementAndGet(), "Barry", "Allen"));
        this.peopleList.add(new Person(counter.incrementAndGet(), "Peter", "Parker"));
        this.peopleList.add(new Person(counter.incrementAndGet(), "Beto", "Pera"));
        this.peopleList.add(new Person(counter.incrementAndGet(), "Relampago", "Marquinhos"));
    }

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public Person getPersonById(long id) {
        return this.peopleList.stream().filter(person -> person.getId() == id).findFirst().get();
    }

    public Person setPerson(PersonView p) {
        Person newPerson = new Person(counter.incrementAndGet(), p.getName(), p.getLastName());
        this.peopleList.add(newPerson);

        return newPerson;
    }
}
