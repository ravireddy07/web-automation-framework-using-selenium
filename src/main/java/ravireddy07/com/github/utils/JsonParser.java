package ravireddy07.com.github.utils;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.*;
import org.json.simple.parser.*;

public class JsonParser {
    public static JSONObject getTestData() throws IOException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
        return (JSONObject) obj;
    }
}
