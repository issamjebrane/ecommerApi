package com.example.ecommerceApi.users;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, PagingAndSortingRepository<User,Integer> {
    User findByEmailAndPassword(String email,String password);

}
