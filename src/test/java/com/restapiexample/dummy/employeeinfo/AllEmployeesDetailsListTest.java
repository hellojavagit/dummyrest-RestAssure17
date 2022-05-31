package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AllEmployeesDetailsListTest extends TestBase {
    @Test
    public void getEmployeesDetails() {

        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        System.out.println("StatusCode is Success");
        response.prettyPrint();
        System.out.println("-------Verifying Some Of Details Of Employees List------");

        List<?> totalRecords = response.then().extract().path("data");
        System.out.println(" \n Test 1 --> Verifying the Total Records are " +totalRecords.size());

        int verifyId = response.then().extract().path("data[23].id");
        System.out.println("\n Test 2 ---> Verifying id of record at 23  ---->" + verifyId);

        String verify_Name = response.then().extract().path("data[23].employee_name");
        System.out.println("\n Test 3 ---> Verifying employee Name at record 24 is ----> "+ verify_Name);

        String messageFetched = response.then().extract().path("message");
        System.out.println("\n Test 4 ---> Verifying the message ----> " + messageFetched);

        String status = response.then().extract().path("status");
        System.out.println("\n Test 5 ---> Verifying the status message---> " + status);

        List<?> salary= response.then().extract().path("data.findAll{it.id==3}.employee_salary");
        System.out.println("\n Test 6 ---> Verifying the salary of Employee id==3 is : " + salary);

        List<?> age  = response.then().extract().path("data.findAll{it.id==6}.employee_age");
        System.out.println("\n Test 7 ---> Verifying the age of Employee at record id==6 is : " + age);

        List<?> empName= response.then().extract().path("data.findAll{it.id==11}.employee_name");
        System.out.println("\n Test 8 ---> Verifying the name  of Employee at id==11 is : " + empName);


    }
}