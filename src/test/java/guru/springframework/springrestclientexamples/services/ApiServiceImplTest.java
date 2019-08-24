package guru.springframework.springrestclientexamples.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccabo 8/22/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    public static final String API_ROOT = "https://virtserver.swaggerhub.com/CesarNicolasCabo/ApiTest/1.0.0";

    @Test
    public void getInventory() throws Exception{
        String apiUrl = API_ROOT + "/inventory/";

        RestTemplate restTemplate = new RestTemplate();

        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        System.out.println("Response: ");
        System.out.println(jsonNode.toString());
    }

    // FIX THIS
    /*@Test
    public void createNewInventoryItem() {
        String apiUrl = API_ROOT + "/inventory/";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> postMap = new HashMap<>();
        postMap.put("name", "Widget Adapter 2");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, postMap, JsonNode.class);

        System.out.println("Response: ");
        System.out.println(jsonNode.toString());
    }*/
}