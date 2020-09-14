package com.example.restgreeting.usecase;

import com.example.restgreeting.gateway.PeopleGateway;
import com.example.restgreeting.gateway.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPersonById {

    private final PeopleGateway peopleGateway;

    @Autowired
    public GetPersonById(final PeopleGateway peopleGateway) {
        this.peopleGateway = peopleGateway;
    }

    public Person execute(long id) {
        return this.peopleGateway.getPersonById(id);
    }
}
