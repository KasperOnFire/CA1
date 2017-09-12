/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;

/**
 *
 * @author Anton
 */
public interface PersonFacadeInterface {
    
    public Person createPerson(Person person);
    
    public Person deletePerson(int id);
    
    public Person updatePerson(Person person);
     
    public Person getPerson(int phoneNumber);
    
    public List<Person> getPersonsHobby(String hobby);
    
    public List<Person> getPersonsCity(String city, int zipCode);
    
    public int getPersonsHobbyCount(String hobby);
    
}
