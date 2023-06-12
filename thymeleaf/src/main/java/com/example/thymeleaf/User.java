package com.example.thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter // getter 생성
@Setter // setter 생성
@ToString // toString
@EqualsAndHashCode
@Data // getter, setter, toString, equals 를 생성
@AllArgsConstructor // 모든 필드를 받는 생성자
@NoArgsConstructor // 기본 생성자
public class User {
	private String username;
	private int age;

}
