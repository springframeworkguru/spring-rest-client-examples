package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<User> getUsers(Integer limit) {

        List<User> userData = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users?limit=" + limit, List.class);
        return userData;
    }
}
