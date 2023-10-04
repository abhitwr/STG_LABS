
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MyConnectorTest {
    MyConnector myConnector = new MyConnector();

    @Test
    void testFetchDetailsByName() throws IOException, InterruptedException {
        String result = myConnector.fetchDetailsByName("mike");
        ObjectMapper map = new ObjectMapper();
        JsonNode node = map.readTree(result);
        Assertions.assertEquals("mike",node.get("name").textValue());
    }
}

