package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by ccabo 8/22/19
 */
@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;
    private final String api_url;

    @Autowired
    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api_url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("limit", limit);

        UserData userData = restTemplate
                .getForObject(uriComponentsBuilder.toUriString(), UserData.class);
        return userData.getData();
    }

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {

        return WebClient.create(api_url)
                .get()
                .uri(uriBuilder -> uriBuilder.queryParam("limit", limit.block()).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(resp -> resp.bodyToMono(UserData.class))
                .flatMapIterable(UserData::getData);
    }
}
