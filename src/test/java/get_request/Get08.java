package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {
    //De-Serialization:  Json datayı Java objesine cevirme
    //Serialization: Java objesini Json formatına cevirme
    //De-Serialization:  İki turlu yapacagız.
    //Gson: Google tarafından üretilmiştir
    //Object Mapper: Daha populer..

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */
    //Set the url
    //Set the expected data
    //send the request and get the response
    //Do Asssertions

    @Test
    public void get08() {
        //Set the url
        spec.pathParams("first","todos","second",2);
        //Set the expected data ==> Payload
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println(expectedData);
        System.out.println("expectedData = " + expectedData);
        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do Asssertions
        Map<String,Object> actualData=response.as(HashMap.class);//De-Serialization ==> Json'i Java'ya cevirdim
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));
        assertEquals(200,response.statusCode());



    }
}
