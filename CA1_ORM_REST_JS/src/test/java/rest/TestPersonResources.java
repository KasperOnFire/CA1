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
    
    //To save time, we are testing wihtout a testdatabse
    
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
    
    //**WARNING**
    //Following two tests works, but remeber this is not running on a test database. 
    
//    @Test
//    public void createPerson(){
//        Map<String,String> p = new HashMap<>();
//        p.put("firstName", "Kasper");
//        p.put("lastName", "Vink");
//        p.put("email", "penisenlargementindustries@verylarge.com");
//        
//
//        given()
//        .contentType("application/json")
//        .body(p)
//        .when().post("http://dev.breindal.me/CA1_ORM_REST_JS/api/person/").then()
//        .statusCode(200);
//    }
//    
//    @Test
//    public void deletePerson(){
//        given().pathParam("id", ***INSERT VALID ID***)
//        .when().delete("http://dev.breindal.me/CA1_ORM_REST_JS/api/person/{id}")
//        .then().statusCode(200);
//        
//    }
    
    
    
}
