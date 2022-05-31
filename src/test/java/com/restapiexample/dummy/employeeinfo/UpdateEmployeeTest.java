package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.DummyRestPojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateEmployeeTest extends TestBase {
    @Test
    public void updateEmployee(){

        DummyRestPojo dummyRestPojo = new DummyRestPojo();
        dummyRestPojo.setEmployee_Name("HiHello");
        dummyRestPojo.setEmployee_Salary(80000);
        dummyRestPojo.setEmployee_Age(50);
        dummyRestPojo.setProfileImage("");

        Response response = given()

                .header("Content-Type", "application/json")
                .pathParam("id",21)
                .body(dummyRestPojo)
                .when()
                .put("/update/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
