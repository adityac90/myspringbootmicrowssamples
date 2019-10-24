package com.example.demo.jpa;

import com.example.demo.jpa.entities.Person;
import com.example.demo.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JpAtutorialApplication implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpAtutorialApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        final Person person = personRepository.findById(10001);
        System.out.println(person);

        Person person1 = new Person();
        person1.setFirstName("Radha");
        person1.setLastName("Shyam");
        person1.setAge(45);
        person1.setGender("Female");

        final Person person2 = personRepository.savePerson(person1);
        System.out.println(person2);

        System.out.println(personRepository.findAll());

        personRepository.deleteById(10006);


    }
}
