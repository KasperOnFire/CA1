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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    private static int nextId = 0;
    private PersonFacadeImpl pfi = new PersonFacadeImpl();

    @GET
    @Path("complete/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<Person> pl = pfi.getAllPersons();
        if(pl == null){
            throw new WebApplicationException();
        }
        
        return gson.toJson(pl);
    }

    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIdJson(@PathParam("id") int id) {
        Person p = pfi.getPerson(id);
        
        if(p == null){
           throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(p);
    }

    @GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContactAll() {
        ArrayList<Person> per1 = (ArrayList<Person>) pfi.getAllPersons();
        ArrayList<Person> personsContact = new ArrayList();
        for (Person op : per1) {
            Person p = new Person();
            p.setId(op.getId());
            p.setFirstName(op.getFirstName());
            p.setLastName(op.getLastName());
            p.setEmail(op.getEmail());
            p.setPhone(op.getPhone());
            p.setAddress(op.getAddress());
            personsContact.add(p);
        }
        return gson.toJson(personsContact);
    }

    @GET
    @Path("contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContactFromId(@PathParam("id") int id) {
        Person op = pfi.getPerson(id);
        Person p = new Person();
        p.setId(op.getId());
        p.setFirstName(op.getFirstName());
        p.setLastName(op.getLastName());
        p.setEmail(op.getEmail());
        p.setPhone(op.getPhone());
        p.setAddress(op.getAddress());
        return gson.toJson(p);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String content) {
        Person p = gson.fromJson(content, Person.class);
        pfi.createPerson(p);
        return gson.toJson(p);
    }
}
