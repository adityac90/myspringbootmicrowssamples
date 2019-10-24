package com.example.demo.jpa.repository;

import com.example.demo.jpa.entities.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person findById(long id) {

        return entityManager.find(Person.class, id);
    }

    @Transactional
    public void deleteById(long id) {
        Person p = findById(id);
        entityManager.remove(p);
    }

    @Transactional
    public Person savePerson(Person person) {
        return entityManager.merge(person);
    }

    public List<Person> findAll() {
        //entityManager.createQuery()
        final TypedQuery<Person> get_all_persons = entityManager.createNamedQuery("GET_ALL_PERSONS", Person.class);
        return get_all_persons.getResultList();
    }
}
