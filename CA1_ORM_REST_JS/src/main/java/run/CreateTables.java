package run;

import entity.Company;
import entity.Person;
import facade.CompanyFacadeImpl;
import facade.PersonFacadeImpl;
import interfaces.CompanyFacadeInterface;
import interfaces.PersonFacadeInterface;
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
        CompanyFacadeInterface cfi = new CompanyFacadeImpl();
        PersonFacadeInterface pfi = new PersonFacadeImpl();
        Generator gen = new Generator(20);
        for (Company company : gen.cList) {
            cfi.createCompany(company);
        }
        for (Person person : gen.pList) {
            pfi.createPerson(person);
        }

    }

}
