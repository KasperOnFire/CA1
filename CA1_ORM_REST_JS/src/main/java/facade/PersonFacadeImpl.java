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
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author KnaldeKalle
 */
public class PersonFacadeImpl implements PersonFacadeInterface {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("COS5");
    EntityManager em = emf.createEntityManager();

    @Override
    public Person createPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        
        try{
       em.getTransaction().begin();
       em.persist(person);
       em.getTransaction().commit();
        } finally {
            em.close();
            }
            
            return person;
        
        
    }

    @Override
    public Person deletePerson(int id) {
         EntityManager em = emf.createEntityManager();       
        Person person = em.find(Person.class, id);
        try{
 
  em.getTransaction().begin();
  em.remove(person);
  em.getTransaction().commit();
        } finally {
            em.close();
        }
        
        return person;
    }

    @Override
    public Person updatePerson(Person person, int id) {
         EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        try{
        
        em.getTransaction().begin();
        p = person;
        em.getTransaction().commit();
        } finally {
            em.close();
        }
        
        return p;
        
    }

    @Override
    public Person getPerson(int id) {
//        Query q = em.createNamedQuery("Person.findById");
//        q.setParameter(name, q)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public List<Person> getPersonsHobby(String hobby) {
       
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.hobby = :hobby");
        q.setParameter("hobby", hobby);
        List<Person> hobbyList = q.getResultList();
        return hobbyList;
        
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
