package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get07 extends JsonplaceholderBaseUrl {
    /*
      Given
       https://jsonplaceholder.typicode.com/todos
When
    I send GET Request to the URL == > URL'e Get Request gonderin
Then
    1)Status code is 200 == > Status kodu 200 olmali
    2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
      Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
    3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
      Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
    4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
      Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
      basliginin "delectus aut autem" icerdigini dogrulayin
   */
    @Test
    public void get01(){
        //set the url
        spec.pathParam("first","todos");

        //set the expected data

        //send the request and get the response
        Response response=given().spec(spec).get("/{first");
        //response.prettyPrint();

        //Do assertion
        //1)Status code is 200 == > Status kodu 200 olmali
        response.then().assertThat().statusCode(200);

        //2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
        JsonPath json=response.jsonPath();
        List<Integer> ids=json.getList("findAll{it.id>190}.id"); //Grovy Language= Java Temelli programlama dili
        System.out.println("Id'si 190'dan buyuk olanlar : "+ids);

        //      Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
        assertEquals("id 190'dan buyuk olan eslesmedi ", 10,ids.size());
        //    3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
        List<Integer> userIds=json.getList("findAll{it.id<5}.userId");
        System.out.println("Id'si 5'den kucuk olan UserIdler :"+userIds);
        //      Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
        assertEquals("Id'si 5'den kucuk olan User Id'ler 4 tane degil ",4,userIds.size());
        //    4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
        List<String> titles=json.getList("findAll{it.id<5}.title");
        System.out.println("Id'si 5 ten kucuk olan titlelar :"+titles);
        //      Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
        //      basliginin "delectus aut autem" icerdigini dogrulayin
        assertTrue("Id'si 5 den kucuk olan Title'lardan herhangi bir tanesi delectus aut icermemektedir. ",
                titles.contains("delectus aut autem"));

        assertTrue("Id'si 5 den kucuk olan Title'lardan herhangi bir tanesi delectus aut icermemektedir. ",
                titles.stream().anyMatch(t->t.equals("delectus aut autem")));


    }
}
