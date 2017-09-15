/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

/**
 *
 * @author KnaldeKalle
 */
public class TestPersonResources {
    
    
    @Test
    public void getJson(){
        given().when().get("http://dev.breindal.me/CA1_ORM_REST_JS/api/person/complete/").then().statusCode(200);
        given().when().get("http://dev.breindal.me/CA1_ORM_REST_JS/api/person/complete/").then().body(containsString("Kim"));
}
    
    @Test
    public void getByIdJson(){      
        given().when().get("http://dev.breindal.me/CA1_ORM_REST_JS/api/person/complete/55").then().body("firstName",equalTo("Rusty"));       
    }
    
    @Test
    public void getContactAll(){
        given().when().get("http://dev.breindal.me/CA1_ORM_REST_JS/api/person/contactinfo").then().body(containsString("Lenormand"));
    }
    
    @Test
    public void getContactFromId(){
        given().when().get("http://dev.breindal.me/CA1_ORM_REST_JS/api/person/contactinfo/52").then().body(containsString("Lenormand"));
    }
}
