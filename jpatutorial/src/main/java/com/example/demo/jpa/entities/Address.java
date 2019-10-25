package com.example.demo.jpa.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long address_id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private long zipCode;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Person person;

}
