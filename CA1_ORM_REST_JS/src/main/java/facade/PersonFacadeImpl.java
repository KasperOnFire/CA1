package facade;

import entity.Person;
import interfaces.PersonFacadeInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * 
 * Facade for persisting and removing entities of the Person class
 *
 * @author KnaldeKalle
 */
public class PersonFacadeImpl implements PersonFacadeInterface {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("COS5");
    EntityManager em;


    @Override
    public Person createPerson(Person person) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return person;

    }

    @Override
    public Person deletePerson(long id) {
        em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return person;
    }

    @Override
    public Person updatePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, person.getId());
        try {
            em.getTransaction().begin();
            p = person;
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;

    }

    @Override
    public Person getPerson(long id) {
        em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        em.close();
        return p;
    }

    @Override
    public List<Person> getAllPersons() {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("Select p from Person p");
            em.getTransaction().commit();
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
