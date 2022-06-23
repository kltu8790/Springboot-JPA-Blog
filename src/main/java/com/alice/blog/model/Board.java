package com.alice.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!
@Entity
public class Board {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id; 
	
	@Column(nullable = false, length = 100)
	private String title; //제목
	
	@Lob //대용량 데이터 쓸때 사용
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨. 그러면 글자의 용량 MAX
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne(fetch = FetchType.EAGER) // Many = Many , User = One (한명의 유저는 여러개의 게시글을 쓸수있고, 여러개의 게시글은 한명에의해 써질 수 있음)
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아니게 된다(난 FK가 아니에요) DB에 칼럼을 만들지 마세요.
	private List<Reply> reply;
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;

}
