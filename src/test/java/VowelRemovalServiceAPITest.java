import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.List;

public class VowelRemovalServiceAPITest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost"; // Replace with your base URL
        RestAssured.port = 8080; // Replace with your port if different
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("testDataProvider")
    public void testVowelRemoval(String title, String input, String expectedOutput, int contentLength) {
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/" + input)
                .then()
                .statusCode(200)
                .body(equalTo(expectedOutput))
                .header("Content-Length", Integer.toString(contentLength));
    }

    public static List<Object[]> testDataProvider() throws IOException {
        List<JSONDataLoader.TestCase> testCases = JSONDataLoader.loadTestCases();
        return testCases.stream()
                .map(tc -> new Object[]{tc.title, tc.input, tc.expectedOutput, tc.contentLength})
                .toList();
    }
}
