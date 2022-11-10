package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01b {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void get01() {
        //set the url
        String url= "https://reqres.in/api/users/3";

        //set the expected data


        //Send the request and get the response
        Response response= given().when().get(url);
        response.prettyPrint();

        //Do Asseertion

        // HTTP Status Code should be 200
        // Content Type should be JSON
        // Status Line should be HTTP/1.1 200 OK
        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


    }
}
