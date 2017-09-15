/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import interfaces.PersonFacadeInterface;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import testData.Generator;

/**
 *
 * @author Kasper
 */
public class PersonFacadeImplTest {

    PersonFacadeInterface instance;
    Random r;

    public PersonFacadeImplTest() {
        r = new Random();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new PersonTestFacade(new Generator(10));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPerson method, of class PersonFacadeImpl.
     */
    @org.junit.Test
    public void testCreatePerson() {
        System.out.println("createPerson");
        Person person = new Person();
        person.setFirstName("Kasper");
        person.setLastName("Breindal");
        Person expResult = person;
        Person result = instance.createPerson(person);
        assertEquals(expResult, result);
    }

    /**
     * Test of deletePerson method, of class PersonFacadeImpl.
     */
    @org.junit.Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        long id = 3;
        Person expResult = instance.getPerson(id);
        Person result = instance.deletePerson(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of updatePerson method, of class PersonFacadeImpl.
     */
//    @org.junit.Test
//    public void testUpdatePerson() {
//        System.out.println("updatePerson");
//        Person person = instance.getPerson(1L);
//        person.setFirstName("TestUser");
//        person.setLastName("UserTest");
//        Person expResult = person;
//        Person result = instance.updatePerson(person);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of getPerson method, of class PersonFacadeImpl.
     */
    @org.junit.Test
    public void testGetPerson() {
        System.out.println("getPerson");
        long id = 4;
        int expResult = 4;
        Person p = instance.getPerson(id);
        long result = p.getId();
        if (p instanceof Person) {
            assertEquals(expResult, result);
        } else {
            fail("Not a person");
        }
    }

    /**
     * Test of getAllPersons method, of class PersonFacadeImpl.
     */
    @org.junit.Test
    public void testGetAllPersons() {
        System.out.println("getAllPersons");
        int expResult = 10;
        int result = instance.getAllPersons().size();
        assertEquals(expResult, result);
    }

}
