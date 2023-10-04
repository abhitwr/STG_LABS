import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MyConnectorTest {
    MyConnector myConnector = new MyConnector();

    @Test
    void testFetchDetailsByName() throws IOException, InterruptedException {
        String result = myConnector.fetchDetailsByName("mike");
        Assertions.assertNotNull(result);
    }
}

