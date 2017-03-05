package web;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by AMogilnikov on 02.03.2017.
 */
public class RestAssuredTest {
    @Test
    public void itEbooks() {
        when()
                .get("http://it-ebooks-api.info/v1/search/java")
         .then()
                .body("Error", equalTo("0"));
//                .body("Books.",);


    }
}
