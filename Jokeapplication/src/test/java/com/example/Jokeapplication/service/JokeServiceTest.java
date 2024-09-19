package com.example.Jokeapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import com.example.Jokeapplication.Entity.Joke;
import com.example.Jokeapplication.Repository.JokeRepository;

class JokeServiceTest {

	@Mock
	 RestTemplate restTemplet;
	@Mock
	JokeRepository jokeRepository;
	@InjectMocks
	JokeService jokeService;
	@Mock
	Joke mjoke;

	@BeforeEach
	void setUp() throws Exception {
		mjoke = Joke.builder().id(1).punchine("punchline").type("type").
			 	setUp("setup").build();
	}

	@Test
	void testGetRandomJokes() {
		String URL = "https://official-joke-api.appspot.com/random_joke";
		when(restTemplet.getForObject(URL, Joke.class)).thenReturn(mjoke);
		
		List<Joke> res = jokeService.getRandomJokes(5);
		
		assertEquals(5, res.size());
		assertNotNull(res.get(0));
	}
	
	@Test
	void testGetRandomJokesFailcase() {
		String URL = "https://official-joke-api.appspot.com/random_joke";
		when(restTemplet.getForObject(URL, Joke.class)).thenReturn(null);
		
		List<Joke> res = jokeService.getRandomJokes(4);
		
		assertNull(res.get(0));
	}
	
	@Test
	void testAddJoke() {
		when(jokeRepository.save(mjoke)).thenReturn(mjoke);	
		String a =jokeService.addJoke(mjoke);
		assertEquals("Joke added successfully", a);
	}

}
