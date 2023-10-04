
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class MyConnectorTest {

    @InjectMocks
    MyConnector myConnector;

    @Test
    void testFetchDetailsByName() throws IOException, InterruptedException {
        String result = myConnector.fetchDetailsByName("mike");
        ObjectMapper map = new ObjectMapper();
        JsonNode node = map.readTree(result);
        Assertions.assertEquals("mike",node.get("name").textValue());
    }
}

