import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

class MyServiceTest {
    @Mock
    MyConnector myConnector;
    @InjectMocks
    MyService myService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAnyPerson() throws IOException, InterruptedException, ExecutionException {
        when(myConnector.fetchDetailsByName(anyString())).thenReturn(anyString());

        CompletableFuture<Object> result = myService.getAnyPerson();
        Assertions.assertNotNull(result);
    }
}
