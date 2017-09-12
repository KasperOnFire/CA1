package facade;

import entity.Company;
import java.util.ArrayList;
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
        em = emf.createEntityManager();
        Company c;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select c from Company as c where c.id = :id");
            q.setParameter("id", company.getId());
            c = (Company) q.getResultList().get(0);
            c = company;
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Company> getAllCompany() {
        em = emf.createEntityManager();
        List<Company> companies = new ArrayList();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("Select Company c from Company");
            companies = q.getResultList();

        } finally {
            em.close();
        }
        return companies;
    }

    @Override
    public Company getCompany(long id) {
        em = emf.createEntityManager();
        Company c;
        try {

            Query q = em.createQuery("Select Company c from Company where c.id = :id");
            q.setParameter("id", id);
            c = (Company) q.getResultList().get(0);
        } finally {
            em.close();
        }
        return c;
    }

}
