package guru.springframework.springrestclientexamples.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
public class User {
    private Gender gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String phone;
    private Job job;
    private Billing billing;
    private String language;
    private String currency;
}
