package com.alice.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 빌더 패턴!
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity// user 클래스를 통해서 private를 읽어서 자동으로 mysql에 테이블이 생성
public class Reply {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략 따라가기
	private int id; // 시퀀스,  auto_increment
	
	@Column(nullable = false, length = 200)
	private String content; 
	
	@ManyToOne //여러개의 답변은 하나의 게시글이 존재할 수 있다.
	@JoinColumn(name="boardId")
	private Board board; // 얘가 foreign key
	
	@ManyToOne //여러개의 답변은 하나의 유저가 달 수 있다.
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
