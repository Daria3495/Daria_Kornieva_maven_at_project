package rest.hometask;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.parsing.Parser.JSON;

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

    @Test
    public void getCategory() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.chucknorris.io/jokes/categories")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        String categories = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract().body().asString();
        System.out.println("List of categories: \n" +  categories);
    }

    @Test
    public void getJokeByCategory() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.chucknorris.io/jokes/random?category=celebrity")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        String jokeByCategory = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .extract().path("value");
        System.out.println("Joke by Celebrity category: \n" +  jokeByCategory);
    }

    @Test
    public void getFreeText() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.chucknorris.io/jokes/search?query=Chaz%20Bono")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        String freeJoke = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .defaultParser(Parser.JSON)
                .extract().body().asString();
        System.out.println("Free Chuck Norris joke is: \n" +  freeJoke);
    }
}
