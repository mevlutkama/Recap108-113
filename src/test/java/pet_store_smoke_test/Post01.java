package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.Category;
import pojos.PetStorePet;
import pojos.Tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Post01 extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet
    And
        {
                          "id": 1234321,
                          "category": {
                            "id": 0,
                            "name": "horse"
                          },
                          "name": "dorsie",
                          "photoUrls": [
                            "string"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "my cute horse"
                            }
                          ],
                          "status": "available"
                        }
     When
        User sends Post Request
     Then
        HTTP Status code is 200
     And
        Response body is like:
                            {
                            "id": 1234321,
                            "category": {
                                "id": 0,
                                "name": "horse"
                            },
                            "name": "dorsie",
                            "photoUrls": [
                                "string"
                            ],
                            "tags": [
                                {
                                    "id": 0,
                                    "name": "my cute horse"
                                }
                            ],
                            "status": "available"
                        }
     */
    @Test
    public void post01() throws IOException {
        // Set the Url
        spec.pathParam("first", "pet");

        // Set the expected data
        Category category = new Category(0, "horse");
        Tags tags = new Tags(0, "my cute horse");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("string");
        ArrayList<Tags> arraylistTags = new ArrayList<>();
        arraylistTags.add(tags);

        PetStorePet expectedData = new PetStorePet(1234321, category, "dorsie", arrayList, arraylistTags, "available");
        System.out.println("expectedData = " + expectedData);

        // Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        // Do Assertion
        PetStorePet actualData = new ObjectMapper().readValue(response.asString(), PetStorePet.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getCategory().getId(), actualData.getCategory().getId());
        assertEquals(expectedData.getCategory().getName(), actualData.getCategory().getName());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(expectedData.getTags().get(0).getId(), actualData.getTags().get(0).getId());
        assertEquals(expectedData.getTags().get(0).getName(), actualData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
    }
}
