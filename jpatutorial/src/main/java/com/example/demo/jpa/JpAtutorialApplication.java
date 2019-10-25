package com.example.demo.jpa;

import com.example.demo.jpa.entities.Address;
import com.example.demo.jpa.entities.Person;
import com.example.demo.jpa.repository.AddressRepository;
import com.example.demo.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@SpringBootApplication
@EnableTransactionManagement
public class JpAtutorialApplication implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpAtutorialApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
       /* final Person person = personRepository.findById(10001);
        System.out.println(person);*/

        Person person1 = new Person();
        person1.setFirstName("Radha");
        person1.setLastName("Shyam");
        person1.setAge(45);
        person1.setGender("Female");
        final Optional<Address> byId = addressRepository.findById(2L);
        if (byId.isPresent()) {
            person1.setAddress(byId.get());
        }


       /* Address a = new Address();
        a.setAddress_id(2);
        a.setAddress1("1afa");
        a.setAddress2("afafaf");
        a.setCity("afafa5");
        a.setState("ff");
        a.setZipCode(4545);
        person1.setAddress(a);*/

        final Person person2 = personRepository.savePerson(person1);
        System.out.println(person2);

        System.out.println(personRepository.findById(person2.getId()));




    }
}
