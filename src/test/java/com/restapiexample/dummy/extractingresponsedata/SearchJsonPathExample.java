package com.restapiexample.dummy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://dummy.restapiexample.com";
        RestAssured.basePath = "/api/v1";
        response = given()
                .when()
                .get("/employees")
                .then().statusCode(200);
    }


    // 1) total records are 24
    @Test
    public void test001() {
        List<?> total = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of records are : " + total.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 2) verify data[23].id = 24
    @Test
    public void test002() {
        int verifyId  = response.extract().path("data[23].id");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying the id number: " + verifyId);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3)  verify data[23].employee_name = “Doris Wilder”
    @Test
    public void test003() {
        String empName = response.extract().path("data[23].employee_name");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying employee name of particular id : " + empName);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    // 4) message = “Successfully! All records has been
    //fetched.”
    public void test004() {
        String successMessage = response.extract().path("message");
        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying the success message : "+ successMessage);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)status = success
    @Test
    public void test005() {

        String status = response.extract().path("status");
        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying status : " + status);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) id = 3 has employee_salary = 86000
    @Test
    public void test006() {
       List<String> empSal = response.extract().path("data.findAll{it.id==3}.employee_salary");
        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying the employee salary at particular id  : " +empSal);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7)  id = 6 has employee_age = 61
    @Test
    public void test007() {
        List<String> empAge  = response.extract().path("data.findAll{it.id==6}.employee_age");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying age of employee at id =6 " + empAge);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) id = 11 has employee_name = Jena Gaines
    @Test
    public void test008() {
        List<String> verifyName = response.extract().path("data.findAll{it.id==11}.employee_name");

        System.out.println("\n------------------StartingTest---------------------------");
        System.out.println("Verifying the employee name: " + verifyName);
        System.out.println("------------------End of Test---------------------------");
    }


}
