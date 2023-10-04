import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @Autowired
    private MyConnector myConnector;

    public CompletableFuture<Object> getAnyPerson() {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {

            try {
                return myConnector.fetchDetailsByName("mike");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {

            try {
                return myConnector.fetchDetailsByName("bob");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {

            try {
                return myConnector.fetchDetailsByName("sami");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        });


        List<CompletableFuture<String>> completableFutures = Arrays.asList(completableFuture1, completableFuture2, completableFuture3);

        return CompletableFuture.anyOf(completableFutures.toArray(new CompletableFuture[0]));
    }



}