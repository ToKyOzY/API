package post_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import text_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {
     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post01(){
        //set the url
        spec.pathParam("1","todos");

        //set the expected data
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        Map<String,Object> expectetData= obj.expectedDataMethod(55,"Tidy your room",false);

        //send the request and get the response
        Response response= given().spec(spec).contentType(ContentType.JSON).body(expectetData).when().post("/{1}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData= response.as(HashMap.class);

        assertEquals(expectetData.get("completed"),actualData.get("completed"));
        assertEquals(expectetData.get("title"),actualData.get("title"));
        assertEquals(expectetData.get("userId"),actualData.get("userId"));




    }






}
