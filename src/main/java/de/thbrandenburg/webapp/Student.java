package de.thbrandenburg.webapp;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends Person{
    private Long id;

    public Student(String firstName, String lastName) {
       super(firstName, lastName);
    }

    public Student(String firstName){
        super(firstName);
    }

    public Student(){ }

    public void setId(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId(){
        return id;
    }
}
