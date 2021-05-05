package de.thbrandenburg.webapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor extends Person {
    private Long id;

    public Professor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Professor(String firstName){
        super(firstName);
    }

    public Professor(){ }

    public void setId(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId(){
        return id;
    }
}
