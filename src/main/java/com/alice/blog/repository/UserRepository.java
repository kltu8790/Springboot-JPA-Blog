package com.alice.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alice.blog.model.User;

//DAO
//자동으로 bean등록이 된다.
//@Repository //생략이 가능하다.
//해당 JpaRepository는 User테이블이 관리하는 Repository이고, 이 User테이블의 프라이머리키는 Integer다.
public interface UserRepository extends JpaRepository<User, Integer>{

}
