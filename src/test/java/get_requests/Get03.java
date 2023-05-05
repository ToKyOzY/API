package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 extends JsonplaceholderBaseUrl {
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
        //pathParams kullanma sebebimiz bir den fazla url eklentisi olmasi /todos ve /23 ornegin bu url de
        //eger tek bir eklenti olsaydi o zaman pathParam kullanacaktik, yani /todos tan sonra baska bir sey olmasaydi

        //Expected Data

        //send the request and get response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        //1. Yol: (Hard Assert)
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        //2. YOl: Sadece body icerisinde gecerl bir
        response.then().
                assertThat().
                statusCode(200).contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));


        /*
    Soft assert testi gerçekleştirir ve assert başarısız olursa hata fırlatma gerçekleştirmez.
    Hard assert anında hata fırlatır, sonrasında test işlemine devam eder
            */
    }
}
