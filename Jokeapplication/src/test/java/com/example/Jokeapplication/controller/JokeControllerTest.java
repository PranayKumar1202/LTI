package com.example.Jokeapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Jokeapplication.Entity.Joke;
import com.example.Jokeapplication.service.JokeService;

class JokeControllerTest {

	@Mock
	JokeService jokeService;
	@InjectMocks
	JokeController jokeController;
	@Mock
	Joke joke;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testGetMethodName() {
		when(jokeService.getRandomJokes(5)).thenReturn(Arrays.asList(joke));
		ResponseEntity<List<Joke>> res = jokeController.getMethodName(0);
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	@Test
	void testAddJoke() {
		when(jokeService.addJoke(joke)).thenReturn("Joke added");
		ResponseEntity<String> res = jokeController.addJoke(joke);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());

	}

}
