package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get04 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/8065
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                            {
                                "firstname": "Joseph",
                                "lastname": "Brown",
                                "totalprice": 1100,
                                "depositpaid": true,
                                "bookingdates": {
                                    "checkin": "2022-05-01",
                                    "checkout": "2022-05-07"
                                },
                                "additionalneeds": "lunch"
                            }


     */
    @Test
    public void get04(){
        // Set the Url
        spec.pathParams("first","booking", "second", 8065);

        // Set the expected data

        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        JsonPath jsonPath = response.jsonPath();
        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8", response.contentType());
        assertEquals("Joseph", jsonPath.getString("firstname"));
        assertEquals("Brown", jsonPath.getString("lastname"));
        assertEquals(1100, jsonPath.getInt("totalprice"));
        assertEquals(true, jsonPath.getBoolean("depositpaid"));
        assertEquals("2022-05-01", jsonPath.getString("bookingdates.checkin"));
        assertEquals("2022-05-07", jsonPath.getString("bookingdates.checkout"));
        assertEquals("lunch", jsonPath.getString("additionalneeds"));
    }
}
