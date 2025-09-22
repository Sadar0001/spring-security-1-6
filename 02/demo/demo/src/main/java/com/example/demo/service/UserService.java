// make list of user
// mehtods like register login validate getallusers

package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users=new ArrayList<>();
    private PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    public String register(User user){
       String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        users.add(user);
        printAllUsers();
        return "register successfully";
    }

    public String login(User user) {
        boolean valid = users.stream()
                .anyMatch(u ->
                        u.getEmail() != null && u.getPassword() != null &&
                                u.getEmail().equals(user.getEmail()) &&
                                passwordEncoder.matches(user.getPassword(), u.getPassword())
                );
        return valid ? "login successfully" : "login failed";
    }

    public void printAllUsers(){
        System.out.println(users);
    }
}



