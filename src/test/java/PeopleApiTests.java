import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PeopleApiTests {

    @BeforeClass
    public static void Setup()
    {
        //RestAssured.baseURI = "https://swapi.co/api/people/1/";
        //RestAssured.basePath = "people";
        //RestAssured.port = 8080;
    }

    @Test
    public void getPeople(){
        Response response = given()
                                .when()
                .get("https://swapi.co/api/people/1/");
                                //.get("/1");
        People p = response.body().as(People.class);
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
    }
}
