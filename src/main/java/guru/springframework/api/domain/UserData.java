package guru.springframework.api.domain;

import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
public class UserData {

    List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
