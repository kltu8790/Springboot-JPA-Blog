package com.alice.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM -> Java(다른언어)Object -> 테이블로 매핑해주는 기술
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!
@Entity// user 클래스를 통해서 private를 읽어서 자동으로 mysql에 테이블이 생성
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략 따라가기
	private int id; // 시퀀스,  auto_increment
	
	@Column(nullable = false, length = 30)
	private String username; //아이디
	
	@Column(nullable = false, length = 100)// 비밀번호 => 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 60)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // Enum을 쓴다 -> 도메인(범위) 설정 가능 // admin,user,manager 권한 부여 
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;

}
