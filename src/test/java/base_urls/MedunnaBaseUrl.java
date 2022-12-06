package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class MedunnaBaseUrl {
    protected RequestSpecification spec;

    @BeforeEach// Junit Jupiter Annotations
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com/api/").build();
    }
}
