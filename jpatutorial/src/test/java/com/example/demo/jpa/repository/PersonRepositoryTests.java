package com.example.demo.jpa.repository;

//Dirties COntext ..rollbacks any data that has been modified during testing

import com.example.demo.jpa.JpAtutorialApplication;
import com.example.demo.jpa.entities.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpAtutorialApplication.class)
public class PersonRepositoryTests {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void testFindByID() {
        final Person byId = personRepository.findById(10001);
        Assert.assertEquals("Aditya", byId.getFirstName());

    }

    @Test
    @DirtiesContext
    public void testDeleteById() {
        personRepository.deleteById(10005);
        final Optional<Long> any = personRepository.findAll().stream().map(p -> p.getId()).filter(x -> x == 10005).findAny();
        Assert.assertFalse(any.isPresent());
    }

    @Test
    @DirtiesContext
    public void testSavePerson() {
        Person p = new Person();
        p.setFirstName("test");
        p.setLastName("test");
        p.setGender("MALE");
        p.setAge(28);

        final Person person = personRepository.savePerson(p);

        final Optional<String> returnedValue = personRepository.findAll().stream().map(x -> x.getFirstName()).filter(n -> n.equalsIgnoreCase("test")).findAny();
        Assert.assertEquals("test", returnedValue.get());


    }

}
