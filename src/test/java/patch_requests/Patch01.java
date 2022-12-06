package patch_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Patch01 extends ReqresBaseUrl {
/*
     Given
         1) https://reqres.in/api/users/2
         2) {
              "name": "neo"
             }
     When
          I send PATCH Request to the Url
     Then
           Status code is 200
           And response body is like   {
                                              "name": "neo",
                                              "updatedAt": "2022-10-02T12:53:21.675Z"
                                       }
  */
    @Test
    public void patch01() throws IOException {
        // Set the Url
        spec.pathParams("first", "users", "second", 2);

        // Set the expected data
        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("name", "neo");
        
        // Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();
        
        // Do Assertion
        Map<String,String> actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("name"), actualData.get("name"));
    }
}
