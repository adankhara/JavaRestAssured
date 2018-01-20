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

public class StudentPutTests {

    @BeforeClass
    public static void Setup()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "student";
        RestAssured.port = 8080;
    }

    @Test
    public void UpdateStudent_WithPut()
    {
        ArrayList<String> courses  = new ArrayList<String>();
        courses.add("C++");
        courses.add("Java");
        courses.add("Python");

        Student student = new Student();
        student.setFirstName("Rajnikant");
        student.setLastName("Dankhara");
        student.setEmail("rajnikant.dankhara@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .put("101")
                .then()
                .statusCode(200);
    }
}
