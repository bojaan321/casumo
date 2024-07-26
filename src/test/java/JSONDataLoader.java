import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONDataLoader {
    private static final String DATA_FILE_PATH = "src/test/data/vowelRemovalData.json";

    public static List<TestCase> loadTestCases() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(DATA_FILE_PATH),
                mapper.getTypeFactory().constructCollectionType(List.class, TestCase.class));
    }

    public static class TestCase {
        public String title;
        public String input;
        public String expectedOutput;
        public int contentLength;
    }
}