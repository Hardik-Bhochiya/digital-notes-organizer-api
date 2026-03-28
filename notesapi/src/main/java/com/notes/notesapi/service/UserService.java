package com.notes.notesapi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notes.notesapi.entity.User;
import com.notes.notesapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    private User currentUser;

    public User register(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    //Login API 
    public String login(String username,String password){
        try{
            User user = repo.findByUsername(username);
            if(user == null){
                return "USER NOT FOUND";

            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(password,user.getPassword())){
                currentUser = user;
                return "LOGIN SUCCESSFUL";

            }else{
                return "INVALID PASSWORD";
            }
        }catch(Exception e){
            e.printStackTrace();
            return "Error"+e.getMessage();
        }
       
    }
    public User getCurrentUSer(){
        return currentUser;
    }
}

