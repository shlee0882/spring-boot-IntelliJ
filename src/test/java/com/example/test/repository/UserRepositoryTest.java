package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends TestApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setUserAccount("user4");
        user.setEmail("user4@gmail.com");
        user.setPhoneNumber("010-1111-2222");
        user.setRegDt(LocalDateTime.now());
        user.setRegUser("shlee0882");

        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            System.out.println("user: "+selectUser);
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.setUserAccount("modUser1");
            selectUser.setEmail("modUser1@gmail.com");
            selectUser.setModDt(LocalDateTime.now());
            selectUser.setModUser("shlee0882");
            User newUser = userRepository.save(selectUser);
            System.out.println("user: "+newUser);
        });
    }

//    @Test
//    public void delete(){
//        Optional<User> user = userRepository.findById(1L);
//
//        Assert.assertTrue(user.isPresent());    // true
//        user.ifPresent(selectUser ->{
//            userRepository.delete(selectUser);
//        });
//
//        Optional<User> deleteUser = userRepository.findById(1L);
//
//        Assert.assertFalse(deleteUser.isPresent());    // false
//    }


}