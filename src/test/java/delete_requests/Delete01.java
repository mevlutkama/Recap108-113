package delete_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;
import pojos.DummyApiDeleteResponsePojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Delete01 extends DummyRestApiBaseUrl {
/*
        URL: https://dummy.restapiexample.com/api/v1/delete/2
       HTTP Request Method: DELETE Request
       Test Case: Type by using Gherkin Language
       Assert: 	i) Status code is 200
               ii) "status" is "success"
              iii) "data" is "2"
               iv) "message" is "Successfully! Record has been deleted"
     */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/delete/2
    When
        User sends Delete Request
    Then
        Status code is 200
    And
        Response body is like: {
                                "status": "success",
                                "data": "2",
                                "message": "Successfully! Record has been deleted"
                               }
     */
    @Test
    public void delete01() throws IOException {
        // Set the Url
        spec.pathParams("first", "delete", "second", 2);

        // Set the expected data
        DummyApiDeleteResponsePojo expectedData = new DummyApiDeleteResponsePojo("success", "2", "Successfully! Record has been deleted");
        System.out.println("expectedData = " + expectedData);

        // Send the request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        DummyApiDeleteResponsePojo actualData = new ObjectMapper().readValue(response.asString(), DummyApiDeleteResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getData(), actualData.getData());
        assertEquals(expectedData.getMessage(), actualData.getMessage());
    }
}
