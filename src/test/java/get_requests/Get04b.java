package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Get04b extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */
    @Test
    public void get04(){
        //set the url
        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");
        //expected data

        //
        Response response=given().spec(spec).when().get("/{first}");
                response.prettyPrint();

        //Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));
    }
}
