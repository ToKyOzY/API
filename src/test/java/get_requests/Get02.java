package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {
/* Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
            */

    @Test
    public void get01() {
        //Set the url
        String url="    https://restful-booker.herokuapp.com/booking/1";

        //Set the Expected data

        //Type code to send request
        Response response=given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        //Body not found iceriyor mu
        assertTrue(response.asString().contains("Not Found"));
        //Body techproed icermedigi testi
        assertFalse(response.asString().contains("TechProEd"));
        //Server'in Cowboy olup olmadıgı testi
        assertEquals("Cowboy",response.getHeader("Server"));
    }
}
