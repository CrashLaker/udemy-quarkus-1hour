package n1.brightboost.reactive;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloReactiveResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/helloreactive")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy Reactive"));
    }

}