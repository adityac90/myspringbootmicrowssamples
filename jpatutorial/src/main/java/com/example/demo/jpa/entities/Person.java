package com.example.demo.jpa.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQuery(name = "GET_ALL_PERSONS", query = "select p from Person p")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
