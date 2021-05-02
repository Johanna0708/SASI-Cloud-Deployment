package de.thbrandenburg.webapp;


import javax.persistence.Entity;

@Entity
public class Student extends Person{

    public Student(String firstName, String lastName) {
       super(firstName, lastName);
    }

    public Student(String firstName){
        super(firstName);
    }

    public Student(){

}
}
