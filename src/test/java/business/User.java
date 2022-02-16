package business;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    String username;
    String email;
    String phone;
    String website;
    Address address;
    Company company;
}





