package run;

import entity.CityInfo;
import entity.Company;
import entity.Person;
import facade.CityInfoFacade;
import generator.Generator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kasper
 */
public class CreateTables {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("COS5");
        EntityManager em = emf.createEntityManager();

        HashMap puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/populate.sql");
        Persistence.generateSchema("PU", puproperties);

        CityInfoFacade cif = new CityInfoFacade();

        em.getTransaction().begin();
        Generator g = new Generator();
        List<CityInfo> cf = cif.getAllCities();
        ArrayList<Integer> zips = new ArrayList();

        for (int i = 0; i < 300; i++) {
            zips.add(cf.get(i).getZip());
        }

        ArrayList<Company> company = g.generateCompanies(zips, 1);
        for (int i = 0; i < company.size(); i++) {
            em.persist(company.get(i));
        }
        System.out.println("Companies done!");
        ArrayList<Person> persons = g.generatePersons(zips, 2);
        for (int i = 0; i < persons.size(); i++) {
            em.persist(persons.get(i));
        }
        System.out.println("Persons done!");

        System.out.println("commit started...");
        em.getTransaction().commit();
        em.close();

    }

}
