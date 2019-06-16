package guru.springframework.springrestclientexamples;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jt on 9/22/17.
 */
public class RestTemplateExamples {

    public static final String API_ROOT = "https://api.predic8.de:443/shop";

    @Test
    public void getCategories() throws Exception {
        String apiUrl = API_ROOT + "/categories/";

        RestTemplate restTemplate = new RestTemplate();

        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    @Test
    public void getCustomers() throws Exception {
        String apiUrl = API_ROOT + "/customers/";

        RestTemplate restTemplate = new RestTemplate();

        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    @Test
    public void createCustomer() throws Exception {
        String apiUrl = API_ROOT + "/customers/";

        RestTemplate restTemplate = new RestTemplate();

        //Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Joe");
        postMap.put("lastname", "Buck");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, postMap, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    @Test
    public void updateCustomer() throws Exception {

        //create customer to update
        String apiUrl = API_ROOT + "/customers/";

        RestTemplate restTemplate = new RestTemplate();

        //Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Micheal");
        postMap.put("lastname", "Weston");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, postMap, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());

        String customerUrl = jsonNode.get("customer_url").textValue();

        String id = customerUrl.split("/")[3];

        System.out.println("Created customer id: " + id);

        postMap.put("firstname", "Micheal 2");
        postMap.put("lastname", "Weston 2");

        restTemplate.put(apiUrl + id, postMap);

        JsonNode updatedNode = restTemplate.getForObject(apiUrl + id, JsonNode.class);

        System.out.println(updatedNode.toString());

    }

    @Test(expected = ResourceAccessException.class)
    public void updateCustomerUsingPatchSunHttp() throws Exception {

        //create customer to update
        String apiUrl = API_ROOT + "/customers/";

        RestTemplate restTemplate = new RestTemplate();

        //Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Sam");
        postMap.put("lastname", "Axe");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, postMap, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());

        String customerUrl = jsonNode.get("customer_url").textValue();

        String id = customerUrl.split("/")[3];

        System.out.println("Created customer id: " + id);

        postMap.put("firstname", "Sam 2");
        postMap.put("lastname", "Axe 2");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(postMap, headers);

        //fails due to sun.net.www.protocol.http.HttpURLConnection not supporting patch
        JsonNode updatedNode = restTemplate.patchForObject(apiUrl + id, entity, JsonNode.class);

        System.out.println(updatedNode.toString());

    }

    @Test
    public void updateCustomerUsingPatch() throws Exception {

        //create customer to update
        String apiUrl = API_ROOT + "/customers/";

        // Use Apache HTTP client factory
        //see: https://github.com/spring-cloud/spring-cloud-netflix/issues/1777
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        //Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Sam");
        postMap.put("lastname", "Axe");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, postMap, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());

        String customerUrl = jsonNode.get("customer_url").textValue();

        String id = customerUrl.split("/")[3];

        System.out.println("Created customer id: " + id);

        postMap.put("firstname", "Sam 2");
        postMap.put("lastname", "Axe 2");

        //example of setting headers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(postMap, headers);

        JsonNode updatedNode = restTemplate.patchForObject(apiUrl + id, entity, JsonNode.class);

        System.out.println(updatedNode.toString());
    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteCustomer() throws Exception {

        //create customer to update
        String apiUrl = API_ROOT + "/customers/";

        RestTemplate restTemplate = new RestTemplate();

        //Java object to parse to JSON
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("firstname", "Les");
        postMap.put("lastname", "Claypool");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, postMap, JsonNode.class);

        System.out.println("Response");
        System.out.println(jsonNode.toString());

        String customerUrl = jsonNode.get("customer_url").textValue();

        String id = customerUrl.split("/")[3];

        System.out.println("Created customer id: " + id);

        restTemplate.delete(apiUrl + id); //expects 200 status

        System.out.println("Customer deleted");

        //should go boom on 404
        restTemplate.getForObject(apiUrl + id, JsonNode.class);

    }


}
