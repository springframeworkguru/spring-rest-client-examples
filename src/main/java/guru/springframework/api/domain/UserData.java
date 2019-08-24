package guru.springframework.api.domain;

import java.util.List;

/**
 * Created by ccabo 8/22/19
 */
public class UserData {

    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
