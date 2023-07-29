package com.example.ecommerceApi.users;

import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id){
         userRepository.deleteById(id);
    }

    public User updateUser(User user,Integer id){
            User oldUser =  userRepository.findById(id).orElse(null);
            oldUser.setId(oldUser.getId());
            oldUser.setNom(user.getNom());
            oldUser.setEmail(user.getEmail());
            return oldUser;

    }

    public User login(User user){
        try{
           User returnedUser= userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
             return returnedUser;
        }
        catch (NoResultException e)
        {
            System.out.println("no user found");
            return null;
        }
    }

    public Page<User> getUsersByPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return userRepository.findAll(pageable);
    }
}
