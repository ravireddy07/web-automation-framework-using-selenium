package ravireddy07.com.github.utils;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.*;

public class JsonParser {
    public static JSONObject getTestData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
        return (JSONObject) obj;
    }
}
