package com.myCompany.MyWebApp.persistance.dao;

import com.myCompany.MyWebApp.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    void deleteById(Long id);
}
