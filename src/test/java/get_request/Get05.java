package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get05 extends RestfulBaseUrl {
/*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
 */
    @Test
    public void get01(){
        // https://restful-booker.herokuapp.com/booking?firstname=Ali&lastname=Cengiz
        //Set the Url
        spec.pathParam("first","booking").queryParams("firstname","Ali","lastname","Cengiz");

        //Set the expected data

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do Assertion
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasSize(200),
                        "title",hasItem(""));
    }
}
