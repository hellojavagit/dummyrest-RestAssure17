package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.DummyRestPojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateEmployeeTest extends TestBase {
    @Test
    public void createEmployee(){

        DummyRestPojo dummyRestPojo = new DummyRestPojo();
        dummyRestPojo.setName("Hello");
        dummyRestPojo.setSalary(65000);
        dummyRestPojo.setAge(50);
        dummyRestPojo.setId("2000");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(dummyRestPojo)
                .when()
                .post("/create");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
