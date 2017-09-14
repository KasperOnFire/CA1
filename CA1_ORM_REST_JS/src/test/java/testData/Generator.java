package testData;

import entity.InfoEntity;
import entity.Phone;
import entity.Address;
import entity.Person;
import entity.Hobby;
import entity.Company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Kristian
 */
public class Generator {

    private Random r = new Random();

    /**
     * ArrayList containing persons.
     */
    public ArrayList<Person> pList = new ArrayList();

    /**
     * ArrayList containing companies.
     */
    public ArrayList<Company> cList = new ArrayList();

    /**
     * ArrayList containing all hobbies. Currently every test person gets assigned all the hobbies.
     * Hobbies currently only have name, description, and id.
     */
    public ArrayList<Hobby> hList = new ArrayList();

    /**
     * Runs generation of data for testing. Set to generate 10 people and 
     * 10 companies at the moment. Can be changed as necessary.
     */
    public Generator() {
        generate(10);
    }
    
    /**
    * String arrays containing names and such for generating test data.
    */
    private String[] firstName
            = {
                "Thomas", "Peter", "Anders", "Mads", "Michael", "Signe", "Lone", "Hanne", "Janne", "Louise"
            };
    private String[] lastName
            = {
                "Andersen", "Hansen", "Thomsen", "Madsen", "Petersen", "Jensen", "Smith", "Poulsen", "Michaelsen", "Jansen"
            };
    private String[] erhverv
            = {
                "VVS", "Tømrer", "Smed", "Elektriker", "Murer", "Maler"
            };
    private String[] hobbies
            = {
                "Tennis", "Fodbold", "Skydning", "Skoleskyderi", "Kunstmaler", "Amagermanden - wannabe"
            };
    private String[] streets
            = {
                "Langgade", "Kortgade", "Gadegade", "Skolegade", "Kristengade", "Jødegade", "Muslimgade"
            };

    /**
     *
     * @param i
     */
    public void generate(int i) {
        hList = genHobbies();
        for (int j = 0; j < i; j++) {
            Address a = genAddress();
            pList.add(genPerson(hList, a));
            cList.add(genCompany(a));
        }
    }

    private Address genAddress() {
        Address a = new Address();
        a.setStreet(streets[r.nextInt(7)]);
        return a;
    }

    private ArrayList<Hobby> genHobbies() {
        long i = 0;
        ArrayList<Hobby> hList = new ArrayList();
        Hobby h = new Hobby();
        for (int j = 0; j < hobbies.length; j++) {
            h.setName(hobbies[r.nextInt(6)]);
            h.setDescription("null");
            h.setId(i);
            i++;
            hList.add(h);
        }
        return hList;
    }

    private Person genPerson(List<Hobby> hList, Address a) {
        long id = 0 + pList.size();
        Person p = new Person();
        p.setId(id);
        String fName = firstName[r.nextInt(10)];
        p.setFirstName(fName);
        String lName = lastName[r.nextInt(10)];
        p.setLastName(lName);
        p.setHobbies(hList);
        p.setAddress(a);
        Phone ph = new Phone();
        ph.setNumber("" + r.nextInt(100000) + 90000);
        ArrayList<Phone> pL = new ArrayList<Phone>();
        pL.add(ph);
        p.setPhone(pL);
        return p;
    }

    private Company genCompany(Address a) {
        Company c = new Company();
        c.setName(firstName[r.nextInt(10)] + lastName[r.nextInt(10)] + erhverv[r.nextInt(6)]);
        c.setCvr(r.nextInt(800) + 100);
        c.setNumEmployees(r.nextInt(100) + 1);
        c.setMarketValue(r.nextInt(10000) + 1);
        c.setAddress(a);
        Phone ph = new Phone();
        ph.setNumber("" + r.nextInt(100000) + 90000);
        ArrayList<Phone> pL = new ArrayList<Phone>();
        pL.add(ph);
        c.setPhone(pL);
        return c;
    }
}
