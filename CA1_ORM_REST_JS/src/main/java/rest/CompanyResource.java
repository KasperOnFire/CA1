/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Company;
import facade.CompanyFacadeImpl;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author KnaldeKalle
 */
@Path("company")
public class CompanyResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    CompanyFacadeImpl cfi = new CompanyFacadeImpl();

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
    }

   
    
    @GET
    @Path("complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       List<Company> cl = cfi.getAllCompanies();
       if( cl == null){
           throw new WebApplicationException(Response.Status.NOT_FOUND);
       }
       return gson.toJson(cl); 
              
    }

    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIdJson(@PathParam("id") int id) {
        Company c = cfi.getCompany(id);
        
        if(c == null){
           throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(c);
    }
    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String content) {
        Company c = gson.fromJson(content, Company.class);
        if(c == null){
           throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        cfi.createCompany(c);
        return gson.toJson(c);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJson(@PathParam("id") long id){
      Company c = cfi.getCompany(id); 
      
      if(c == null){
           throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
      
      cfi.deleteCompany(id);
      return gson.toJson(c);
      
    }
}
