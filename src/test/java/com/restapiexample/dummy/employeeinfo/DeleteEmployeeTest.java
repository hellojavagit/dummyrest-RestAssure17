package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteEmployeeTest extends TestBase {

    @Test
    public void deleteEmployee(){
        Response response = given()
                .pathParam("id",2)
                .when()
                .delete("/delete/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    }


