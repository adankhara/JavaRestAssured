import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class StudentRestTests {
    /*
     *   given()
     *   set cookies, add auth, adding parameters, setting header info
     *   .when()
     *   GET, POST, PUT, DELETE, PATCH
     *   .then()
     *   Validate status code, extract headers, response, cookies
     */

    @BeforeClass
    public static void Setup()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "student";
        RestAssured.port = 8080;
    }
    /*
     *   given()
     *   set cookies, add auth, adding parameters, setting header info
     *   .when()
     *   GET, POST, PUT, DELETE, PATCH
     *   .then()
     *   Validate status code, extract headers, response, cookies
     */

    @Test
    public void getAllStudents(){

        Response response = given()
                //.baseUri("http://localhost:8080")
                //.basePath("student")
                .when()
                .get("/list"    );

        //System.out.println(response.body().asString());
        //System.out.println(response.body().prettyPrint());
    }

    @Test
    public void Given_WhenInvokedWithCorrectUrl_ThenItShouldReturnStatusOK(){

        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void GivenStudentApiIsHosted_WhenStudentPathInvokedForId1_ThenItShouldReturn(){
        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200)
                .and().body("id", is(1));
    }

    @Test
    public void GetUsingPathParams(){

        given()
                .pathParam("id", 1)
                .when()
                .get("{id}")
                .then()
                .statusCode(200)
                .and().body("id", is(1));
    }

    @Test
    public void Get_With_QueryStringParameters(){

        Response response = given()
                .param("programme", "Financial Analysis")
                .param("limit", 2)
                .when()
                .get("list");

        System.out.println(response.body().prettyPrint());
    }
}
