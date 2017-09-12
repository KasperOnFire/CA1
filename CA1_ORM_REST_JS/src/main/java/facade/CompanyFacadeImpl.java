package facade;

import entity.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CompanyFacadeImpl implements CompanyFacadeInterface {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public CompanyFacadeImpl() {
        emf = Persistence.createEntityManagerFactory("COS5");
    }

    @Override
    public Company createCompany(Company company) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
            return company;
        } finally {
            em.close();
        }
    }

    @Override
    public Company deleteCompany(int cvr) {
        em = emf.createEntityManager();
        Company c;

        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select c from Company as c where c.cvr = :cvr");
            q.setParameter("cvr", cvr);
            c = (Company) q.getResultList().get(0);
            em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public Company updateCompany(Company company) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getCompany(int employeeCount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company getCompany(int phone, int cvr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
