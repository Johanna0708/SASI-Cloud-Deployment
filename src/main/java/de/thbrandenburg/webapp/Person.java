package de.thbrandenburg.webapp;

import javax.persistence.*;


@MappedSuperclass
public abstract class Person {
    private String firstName;
    private String lastName;
    private Integer age = 0;
    private Long id;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName){
        this.firstName = firstName;
    }

    public Person(){

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getID(){
        return id;
    }
}
