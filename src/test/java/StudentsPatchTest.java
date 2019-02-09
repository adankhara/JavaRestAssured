import com.student.model.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class StudentsPatchTest {

    @BeforeClass
    public static void Setup()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "student";
        RestAssured.port = 8080;
    }

    @Test
    public void CreateStudent_WithPatch()
    {
        String body = "{\"id\":\"1\",\"firstName\":\"Test Company\",\"lastName\":\"Man\",\"email\":\"test.man@massaQuisqueporttitor.org\",\"programme\":\"Financial Analysis\",\"courses\":[\"Accounting\",\"Statistics\"]}";

        given()
            .contentType(ContentType.JSON)
        .when()
            .body(body)
            .patch("1")
        .then()
            .statusCode(200);
    }

    @Test
    public void Delete_UsingRest()
    {
        given()
        .when()
            .delete("101")
        .then()
            .statusCode(204);
    }

    @Test
    public void Delete_postCheck_UsingResponseCheck()
    {
        String expectedResponse = "{\"error\":\"Not Found!\"}";

        given()
        .when()
            .delete("101")
        .thenReturn()
            .asString()
            .equals(expectedResponse);
    }

    @Test
    public void PathUpdateStudent_UsingPOJO()
    {
        ArrayList<String> courses  = new ArrayList<String>();
        courses.add("C++");
        courses.add("Java");

        Student student = new Student();
        student.setFirstName("Patch Update");
        student.setLastName("Dankhara");
        student.setEmail("rajnikant.dankhara@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
            .contentType(ContentType.JSON)
        .when()
            .body(student)
            .patch("/101")
        .then()
            .statusCode(200);
    }
}
