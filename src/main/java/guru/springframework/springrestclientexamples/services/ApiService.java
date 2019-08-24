package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by ccabo 8/22/19
 */
@Service
public interface ApiService {

    List<User> getUsers(Integer limit);
}
