package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ccabo 8/22/19
 */
@Service
public interface ApiService {

    List<User> getUser(Integer limit);
}
