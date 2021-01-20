package com.cos.test.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

	List<Movie> movies = new ArrayList<>();
	
	public MovieRepository() {
		movies.add(new Movie(1, "Wonder Woman", 7.53, "20-12-23"));
		movies.add(new Movie(2, "I AM Woman", 7.54, "21-01-14"));
		movies.add(new Movie(3, "I AM HERE", 8.47, "21-01-14"));
		movies.add(new Movie(4, "화양연화", 9.17, "20-12-24"));
		movies.add(new Movie(5, "늑대와 춤을", 9.27, "21-01-14"));
		movies.add(new Movie(6, "마이 미씽 발렌타인", 9.32, "21-01-14"));
		movies.add(new Movie(7, "도굴", 8.48, "20-11-04"));
		movies.add(new Movie(8, "신과함께-죄와 벌", 8.73, "21-01-07"));
		movies.add(new Movie(9, "조제", 8.21, "20-12-10"));
	}
	
	public List<Movie> findAll() {
		return movies;
	}
	
	public Movie findById(int id) {
		return movies.get(id-1);
	}

	public void save(JoinReqDto dto) {
		System.out.println("DB insert 완료");
	}
	
	public void delete(int id) {
		System.out.println("DB delete 완료");
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println("DB update 완료");
	}
}
