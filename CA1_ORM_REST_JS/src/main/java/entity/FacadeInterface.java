/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;




public interface FacadeInterface {
    
    public Person getPerson(int phoneNumber);
    
    public Company getCompany(int phoneNumber, int CVR);
    
    public List<Person> getPersons(Hobby hobby);
    
    
}
