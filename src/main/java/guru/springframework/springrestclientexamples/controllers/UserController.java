package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ccabo 8/23/19
 */
@Slf4j
@Controller
public class UserController {
    public ApiService apiService;

    @Autowired
    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }


}
