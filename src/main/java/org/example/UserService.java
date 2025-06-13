package org.example;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> users=new HashMap<>();

    public String signup(User user){
        if(users.containsKey(user.getEmail())){
           return "User already exists.";
        }
        users.put(user.getEmail(),user);
        return "Signup successful!";
    }

    public String login(String email,String password) {
        User user = users.get(email);
        if (user == null) {
            return "User not found";
        }
        if(!user.getPassword().equals(password)){
            return "Invalid Credentials";
        }
        return "Login successful!";
    }
}
