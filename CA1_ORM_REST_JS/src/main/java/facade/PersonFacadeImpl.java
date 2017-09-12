/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author KnaldeKalle
 */
public class PersonFacadeImpl implements PersonFacadeInterface {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("COS5");
    EntityManager em = emf.createEntityManager();

    @Override
    public Person createPerson(Person person) {
        
       em.getTransaction().begin();
       em.persist(person);
       em.getTransaction().commit();
       return person;
        
    }

    @Override
    public Person deletePerson(int id) {
       
        Person person = em.find(Person.class, id);
 
  em.getTransaction().begin();
  em.remove(person);
  em.getTransaction().commit();
        
        return person;
    }

    @Override
    public Person updatePerson(Person person, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPerson(int phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersonsHobby(String hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersonsCity(String city, int zipCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPersonsHobbyCount(String hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
