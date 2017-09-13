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

public class Generator
{

    Random r = new Random();

    String[] firstName =
    {
        "Thomas", "Peter", "Anders", "Mads", "Michael", "Signe", "Lone", "Hanne", "Janne", "Louise"
    };
    String[] lastName =
    {
        "Andersen", "Hansen", "Thomsen", "Madsen", "Petersen", "Jensen", "Smith", "Poulsen", "Michaelsen", "Jansen"
    };
    String[] erhverv =
    {
        "VVS", "Tømrer", "Smed", "Elektriker", "Murer", "Maler"
    };
    String[] hobbies =
    {
        "Tennis", "Fodbold", "Skydning", "Skoleskyderi", "Kunstmaler", "Amagermanden - wannabe"
    };
    String[] streets =
    {
        "Langgade", "Kortgade", "Gadegade", "Skolegade", "Kristengade", "Jødegade", "Muslimgade"
    };
    
    void generate(int i)
    {
        String data;
        List<Hobby> hList = genHobbies();
        ArrayList<Person> pList = new ArrayList();
        ArrayList<Company> cList = new ArrayList();
        for(int j=0;j<i;j++)
        {
            Address a = genAddress();
            pList.add(genPerson(hList,a));
            cList.add(genCompany(a));
        }
    }
    
    Address genAddress()
    {
        Address a = new Address();
        a.setStreet(streets[r.nextInt(7)]);
        return a;
    }

    List<Hobby> genHobbies()
    {
        long i = 0;
        List<Hobby> hList = new ArrayList();
        Hobby h = new Hobby();
        for (int j = 0; j < hobbies.length; j++)
        {
            h.setName(hobbies[r.nextInt(6)]);
            h.setDescription("null");
            h.setId(i);
            i++;
            hList.add(h);
        }
        return hList;
    }

    Person genPerson(List<Hobby> hList, Address a)
    {
        Person p = new Person();
        String fName = firstName[r.nextInt(10)];
        p.setFirstName(fName);
        String lName = lastName[r.nextInt(10)];
        p.setLastName(lName);
        p.setHobbies(hList);
        p.setAddress(a);
        Phone ph = new Phone();
        ph.setNumber(""+r.nextInt(100000)+90000);
        ArrayList<Phone> pL = new ArrayList<Phone>();
        pL.add(ph);
        p.setPhone(pL);
        return p;
    }
    
    Company genCompany(Address a)
    {
        Company c = new Company();
        c.setName(firstName[r.nextInt(10)]+lastName[r.nextInt(10)]+erhverv[r.nextInt(6)]);
        c.setCvr(r.nextInt(800)+100);
        c.setNumEmployees(r.nextInt(100)+1);
        c.setMarketValue(r.nextInt(10000)+1);
        c.setAddress(a);
        Phone ph = new Phone();
        ph.setNumber(""+r.nextInt(100000)+90000);
        ArrayList<Phone> pL = new ArrayList<Phone>();
        pL.add(ph);
        c.setPhone(pL);
        return c;
    }
}
