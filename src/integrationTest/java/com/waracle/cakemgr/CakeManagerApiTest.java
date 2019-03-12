package com.waracle.cakemgr;

import com.jayway.restassured.RestAssured;
import com.waracle.cakemgr.entity.Cake;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@TestPropertySource(value={"classpath:application.yml"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = CakeManagerApplication.class)
public class CakeManagerApiTest {

    @Value("${server.port}")
    private int port;

    @Before
    public void setup() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void getCakes() {
        RestAssured
                .get("/")
                .then()
                .assertThat()
                .body(equalTo("[{\"id\":1,\"title\":\"Lemon cheesecake\",\"description\":\"A cheesecake made of lemon\",\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"},{\"id\":2,\"title\":\"victoria sponge\",\"description\":\"sponge with jam\",\"image\":\"http://www.bbcgoodfood.com/sites/bbcgoodfood.com/files/recipe_images/recipe-image-legacy-id--1001468_10.jpg\"},{\"id\":3,\"title\":\"Carrot cake\",\"description\":\"Bugs bunnys favourite\",\"image\":\"http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg\"},{\"id\":4,\"title\":\"Banana cake\",\"description\":\"Donkey kongs favourite\",\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"},{\"id\":5,\"title\":\"Birthday cake\",\"description\":\"a yearly treat\",\"image\":\"http://cornandco.com/wp-content/uploads/2014/05/birthday-cake-popcorn.jpg\"},{\"id\":6,\"title\":\"Lemon cheesecake\",\"description\":\"A cheesecake made of lemon\",\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"},{\"id\":7,\"title\":\"victoria sponge\",\"description\":\"sponge with jam\",\"image\":\"http://www.bbcgoodfood.com/sites/bbcgoodfood.com/files/recipe_images/recipe-image-legacy-id--1001468_10.jpg\"},{\"id\":8,\"title\":\"Carrot cake\",\"description\":\"Bugs bunnys favourite\",\"image\":\"http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg\"},{\"id\":9,\"title\":\"Banana cake\",\"description\":\"Donkey kongs favourite\",\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"},{\"id\":10,\"title\":\"Birthday cake\",\"description\":\"a yearly treat\",\"image\":\"http://cornandco.com/wp-content/uploads/2014/05/birthday-cake-popcorn.jpg\"},{\"id\":11,\"title\":\"Lemon cheesecake\",\"description\":\"A cheesecake made of lemon\",\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"},{\"id\":12,\"title\":\"victoria sponge\",\"description\":\"sponge with jam\",\"image\":\"http://www.bbcgoodfood.com/sites/bbcgoodfood.com/files/recipe_images/recipe-image-legacy-id--1001468_10.jpg\"},{\"id\":13,\"title\":\"Carrot cake\",\"description\":\"Bugs bunnys favourite\",\"image\":\"http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg\"},{\"id\":14,\"title\":\"Banana cake\",\"description\":\"Donkey kongs favourite\",\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"},{\"id\":15,\"title\":\"Birthday cake\",\"description\":\"a yearly treat\",\"image\":\"http://cornandco.com/wp-content/uploads/2014/05/birthday-cake-popcorn.jpg\"},{\"id\":16,\"title\":\"Lemon cheesecake\",\"description\":\"A cheesecake made of lemon\",\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"},{\"id\":17,\"title\":\"victoria sponge\",\"description\":\"sponge with jam\",\"image\":\"http://www.bbcgoodfood.com/sites/bbcgoodfood.com/files/recipe_images/recipe-image-legacy-id--1001468_10.jpg\"},{\"id\":18,\"title\":\"Carrot cake\",\"description\":\"Bugs bunnys favourite\",\"image\":\"http://www.villageinn.com/i/pies/profile/carrotcake_main1.jpg\"},{\"id\":19,\"title\":\"Banana cake\",\"description\":\"Donkey kongs favourite\",\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"},{\"id\":20,\"title\":\"Birthday cake\",\"description\":\"a yearly treat\",\"image\":\"http://cornandco.com/wp-content/uploads/2014/05/birthday-cake-popcorn.jpg\"}]"));
    }

    @Test
    public void createCake() {
        Cake testCake = new Cake(1L, "cheesecake", "cheesecake description", "link to cheesecake image");

        RestAssured.given()
                .contentType("application/json")
                .body("{\"id\":21,\"title\":\"Cheesecake\",\"description\":\"description 21\",\"image\":\"image 21\"}")
                .when().post("/cakes").then()
                .statusCode(200);
    }

}
