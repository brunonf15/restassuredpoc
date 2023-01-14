import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class Rest {

	@Test
    public void testGetPersonById() {
        RestAssured.baseURI = "https://swapi.dev/api/";

        given()
            .contentType(ContentType.JSON)
        .when()
            .get("people/1/?format=json")
        .then()
            .statusCode(200)
            .body("name", equalTo("Luke Skywalker"))
            .body("gender", equalTo("male"))
            .body("height", equalTo("172"))
            .body("mass", equalTo("77"))
            .body("hair_color", equalTo("blond"))
            .body("skin_color", equalTo("fair"))
            .body("eye_color", equalTo("blue"))
            .body("birth_year", equalTo("19BBY"))
            .body("homeworld", equalTo("https://swapi.dev/api/planets/1/"));
    }

}
