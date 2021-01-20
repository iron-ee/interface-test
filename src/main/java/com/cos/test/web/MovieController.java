package com.cos.test.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.test.domain.CommonDto;
import com.cos.test.domain.JoinReqDto;
import com.cos.test.domain.Movie;
import com.cos.test.domain.MovieRepository;
import com.cos.test.domain.UpdateReqDto;

@RestController
public class MovieController {

	private MovieRepository movieRepository;
	
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@CrossOrigin
	
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() {
		System.out.println("findAll 실행");
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll());
	}
	
	@GetMapping("/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) {
		System.out.println("findById 실행");
		return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findById(id));
	}
	
	@PostMapping("/movie")
	public CommonDto<String> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {
		System.out.println("save 실행");
		System.out.println("movie : " + dto);
		movieRepository.save(dto);
		return new CommonDto<String>(HttpStatus.OK.value(), "ok");
	}
	
	@DeleteMapping("/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		System.out.println("delete 실행");
		movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
	}
	
	@PutMapping("/movie/{id}")
	public CommonDto update(@PathVariable int id, @Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		System.out.println("update 실행");
		movieRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
}
