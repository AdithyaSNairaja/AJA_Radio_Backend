package com.AJJ.Radio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AJJ.Radio.Entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
