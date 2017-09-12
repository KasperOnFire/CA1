/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;




public interface FacadeInterface {
    
    public Person getPerson(int phoneNumber);
    
    public Company getCompany(int phone, int cvr);
    
    public List<Person> getPersonsHobby(String hobby);
    
    public List<Person> getPersonsCity(String city, int zipCode);
    
    public int getPersonsHobbyCount(String hobby);
    
    public int[] getZipCodes();
    
    public List<Company> getCompany(int employeeCount);
    
    public Person createPerson(Person person);
    
    public Person deletePerson(int id);
    
    public Person updatePerson(Person person);
    
    public Company createCompany(Company company);
    
    public Company deleteCompany(int cvr);
    
    public Company updateCompany(Company company);
    
    public Hobby createHobby(Hobby hobby);
    
    public Hobby deleteHobbby(String name);
    
    public Hobby updateHobby(Hobby hobby);
    
    public Phone createPhone(Phone phone);
    
    public Phone deletePhone(int number);
    
    public Phone updatePhone(Phone phone);
    
    public Address createAddress(Address address);
    
    public Address deleteAddress(String street, String additionalInfo);
    
    public Address updateAddress(Address address);
    
}
