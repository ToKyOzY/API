package get_request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman, manuel API testleri icin kullandik
    2) Otomasyon testleri icin de Rest Assured Library kullanacagiz.
    3) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz.
        a) Gereksinimleri anlamak
        b) Test case yaziyoruz
            i)Test Case yaziminda "Gherkin" dilini kullanacagiz. Bizler yazilim diline hakim olsak da karşımızdaki kişiler hakim olmayabilir
            ama Gherkin ile yazılan testleri anlamakta zorluk cekmeyeceklerdir
            Gherkin dilinde kullancagımız keywordler;

            -Given : Ön kosullar
            -When : Yapilacak aksiyonlar icin kullanacagız (get(), put(), post(), patch() and delete() )
            -Then : Istek yaptıktan sonra ( request gonderdikten sonra) dogrulama
            -And : Cokluislemlerde kullanacagız

        c) Test code'larimiz yamaya baslayacagiz

            i) Set the URL,
            ii) Set the expected Data (beklenen datanın olusturulmasi, Post, Put, Patch)
            iii) Type code to send request (talep gondermek icin code yazimi)
            iv) Do Assertio (dogrulama yapmak)
     */
    /*
    Given
        https://restful-booker.herokuapp.com/booking/101
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
    public void get01(){
        //i) Set the URL,
        String url= "http://restful-booker.herokuapp.com/booking/101";

        //ii) Set the expected Data (beklenen datanın olusturulmasi, Post, Put, Patch)
        //Bizden Post, Put ya da Patch istenmedigi icin bu casede kullanmayacagiz

       // iii) Type code to send request (talep gondermek icin code yazimi)
       Response response= given().when().get(url);
        response.prettyPeek();

        //iv) Do Assertio (dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //Status code console'a yazdiralim
        System.out.println("Status code : " +response.getStatusCode());

        //Content Type konsola yazdıralim
        System.out.println("Content type : " +response.getContentType());

        //Status Line console'a yzdiralim
        System.out.println("Status line : " +response.getStatusLine());

        //Header console'a yazdiralim
        System.out.println("Header : " +response.getHeader("Server"));

        //Headers console'a yazdiralim
        System.out.println("Headers : "+response.getHeaders());

        //Time console'a yazdiralim
        System.out.println("Time : " +response.getTime());

    }
}
