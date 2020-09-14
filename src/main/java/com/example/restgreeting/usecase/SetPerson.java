package com.example.restgreeting.usecase;

import com.example.restgreeting.gateway.PeopleGateway;
import com.example.restgreeting.gateway.model.Person;
import com.example.restgreeting.model.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetPerson {

    private final PeopleGateway peopleGateway;

    @Autowired
    public SetPerson(final PeopleGateway peopleGateway) {
        this.peopleGateway = peopleGateway;
    }

    public Person execute(PersonView p) {
        return this.peopleGateway.setPerson(p);
    }
}
