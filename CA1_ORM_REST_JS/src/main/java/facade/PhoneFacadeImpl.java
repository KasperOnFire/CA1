/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PhoneFacadeImpl implements PhoneFacadeInterface {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("COS5");
    
    @Override
    public Phone createPhone(Phone phone) {
        EntityManager em = emf.createEntityManager();
        try{     
       em.getTransaction().begin();
       em.persist(phone);
       em.getTransaction().commit();
       
       } finally {
            em.close();
        }
        return phone;
    }

    @Override
    public Phone deletePhone(int number) {
        EntityManager em = emf.createEntityManager();
        Phone phone = em.find(Phone.class, number);
        try{
 
  em.getTransaction().begin();
  em.remove(phone);
  em.getTransaction().commit();
        } finally {
            em.close();
        }
  
       return phone; 
        
    }

   
    
}
