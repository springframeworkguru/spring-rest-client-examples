package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ccabo 8/22/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Before
    public void setUp() throws Exception{
    }

    @Test
    public void testGetUsers() throws Exception{

        List<User> users = apiService.getUser(4);

        assertEquals(4, users.size());
    }
}