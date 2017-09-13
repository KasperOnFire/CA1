/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import facade.PersonFacadeImpl;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author KnaldeKalle
 */
@Path("person")
public class PersonResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Person> persons = new ArrayList<Person>();
    private static int nextId = 0;
    private PersonFacadeImpl pfi = new PersonFacadeImpl();

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
        
        persons = pfi.getAllPersons();
        
              
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson(persons);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIdJson(@PathParam("id") int id) {
        Person p = persons.get(id);
        return gson.toJson(persons.get(id));
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String content) {
        
        Person p = gson.fromJson(content, Person.class);
        persons.add(p);
              
        return gson.toJson(p);
        
    }
}
