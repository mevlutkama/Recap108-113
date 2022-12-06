package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get04b extends HerOkuAppBaseUrl {
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
                                "firstname": "Josh",
                                "lastname": "Allen",
                                "totalprice": 111,
                                "depositpaid": true,
                                "bookingdates": {
                                    "checkin": "2018-01-01",
                                    "checkout": "2019-01-01"
                                },
                                "additionalneeds": "superb owls"
                            }
    */
    @Test
    public void get04(){
        //Set the url
        spec.pathParams("first","booking","second",806);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        JsonPath jsonPath = response.jsonPath();

        //Soft Assertion
        //1st: Create SoftAssert Object
        SoftAssert softAssert = new SoftAssert();

        //2nd: Do Assertion
        softAssert.assertEquals( response.statusCode(),200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getString("firstname"),"Josh");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Allen");
        softAssert.assertEquals(jsonPath.getInt("totalprice"),111);
        softAssert.assertEquals(jsonPath.getBoolean("depositpaid"),true);
        softAssert.assertEquals(jsonPath.getString("additionalneeds"),"superb owls");

        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01");

        //3rd: AssertAll
        softAssert.assertAll();
    }
}
