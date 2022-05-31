package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetEmployeeInfoTest  extends TestBase {
    @Test
    public void getEmployees() {

        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        System.out.println("List Of All Employees");
        response.prettyPrint();
    }
    @Test
    public void singleEmployeeList(){
        Response response = given()
                .pathParam("id", "8")
                .when()
                .get("/employee/{id}");

        response.then().statusCode(200);
        System.out.println("Single Employee List");
        response.prettyPrint();

    }
}

