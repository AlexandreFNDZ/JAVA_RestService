package com.example.restgreeting.usecase;

import com.example.restgreeting.gateway.PeopleGateway;
import com.example.restgreeting.gateway.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPeopleList {

    private final PeopleGateway peopleGateway;

    @Autowired
    public GetPeopleList(final PeopleGateway peopleGateway) {
        this.peopleGateway = peopleGateway;
    }

    public List<Person> execute() {
        return peopleGateway.getPeopleList();
    }
}
