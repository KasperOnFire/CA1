/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import java.util.List;

/**
 *
 * @author Anton
 */
public interface CompanyFacadeInterface {
    
    public Company createCompany(Company company);
    
    public Company deleteCompany(int cvr);
    
    public Company updateCompany(Company company);
    
    public List<Company> getCompany(int employeeCount);
    
    public Company getCompany(int phone, int cvr);
    
}
