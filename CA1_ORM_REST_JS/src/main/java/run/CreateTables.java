package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * This class populates the database with empty tables on manual runtime.
 *
 * @author Kasper
 */
public class CreateTables {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("COS5");
        EntityManager em = emf.createEntityManager();

    }

}
