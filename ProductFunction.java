package co.nz.mycompany.api;

import java.math.BigDecimal;
import java.util.*;

import co.nz.mycompany.domain.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class ProductFunction {
    private static final Product[] mockProducts = new Product[] {
        new Product("10002000300040000000","978020137962", "LAPTOP HP ELITEBOOK", "RAM MEMORY:16 GB, DISK: 256 GB SSD, CPU INTEL COREI7 8TH GENERATION", new BigDecimal("2510.00")),
        new Product("10002000300040001000","978020137965", "LAPTOP HP MOBILEWORKSTATION", "RAM MEMORY:16 GB, DISK: 512 GB SSD, CPU INTEL COREI5 8TH GENERATION", new BigDecimal("2010.50")),
        new Product("10003000300040002000","888020137000", "LAPTOP LENOVO ULTRABOOK", "RAM MEMORY:16 GB, DISK: 512 GB SSD, CPU INTEL COREI7 8TH GENERATION", new BigDecimal("2411.00")),
    };

    /**
     * This function listens at endpoint "/api/Products". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/Products&code={your function key}
     * 2. curl "{your host}/api/Products?name=HTTP%20Query&code={your function key}"
     * Function Key is not needed when running locally, it is used to invoke function deployed to Azure.
     * More details: https://aka.ms/functions_authorization_keys
     */
    @FunctionName("Products")
    public HttpResponseMessage run(@HttpTrigger(name = "req", methods = {HttpMethod.GET},authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,final ExecutionContext context) {
        final ObjectMapper mapper = new ObjectMapper();
        HttpResponseMessage response;

        try {
            String json = mapper.writeValueAsString(mockProducts);
            response = request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .header("Content-Type","application/json")
                    .body(json)
                    .build();
        } catch (JsonProcessingException e) {
            response = request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type","text/plain")
                    .body("Sorry, there were an error processing your request.")
                    .build();
        }
        context.getLogger().info("Java HTTP trigger processed a request.");

        return response;
    }
}