import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get03 extends JsonplaceholderBaseUrl{
     /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
        And
        Response format should be "application/json"
        And
        "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
        And
        "completed" is false
        And
        "userId" is 2
                                 */

    @Test
    public void get01() {
        //set the url
        spec.pathParams("first","todos","second",23);

        //Expected Data

        //send the request and get response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
    }
}
