package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class Get11 extends GoRestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Fr. Paramartha Bandopadhyay", "Pres. Amarnath Dhawan" and "Sujata Chaturvedi" are among the users
        And
            The female users are less than or equals to male users
     */

    @Test
    public void get11() {
       //set the url
       spec. pathParam("first","users");

       //set the expected data (put, post, patch)

        //send the request get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do assertion
        response.then().assertThat().
                statusCode(200).body("meta.pegination.limit",equalTo(10),
                        "meta.pegination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Pres. Amarnath Dhawan","Sujata Chaturvedi","Fr. Paramartha Bandopadhyay"));

        //Kadın ve erkek sayılarını karşılaştıralım
        //1. yol


    }
}
