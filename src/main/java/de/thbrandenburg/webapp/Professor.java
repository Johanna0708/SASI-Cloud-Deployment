package de.thbrandenburg.webapp;

import javax.persistence.Entity;

@Entity
public class Professor extends Person {


    public Professor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Professor(String firstName){
        super(firstName);
    }

    public Professor(){

    }
}
