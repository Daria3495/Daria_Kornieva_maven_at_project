package rest.hometask;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ChuckNorisTest {


    @Test
    public void getJoke(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.chucknorris.io/jokes/random")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
       String joke = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
               .extract().path("value");
        System.out.println("Chuck Noris joke: \n" +  joke);
    }
}
