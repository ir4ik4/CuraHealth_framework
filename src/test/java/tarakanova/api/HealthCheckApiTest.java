package tarakanova.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HealthCheckApiTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @Test
    public void shouldGetPostSuccessfully(){
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
        .body("userId", notNullValue())
                .body("title", not(emptyOrNullString()));

    }

}
