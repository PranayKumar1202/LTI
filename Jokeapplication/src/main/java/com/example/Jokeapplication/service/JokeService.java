package com.example.Jokeapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Jokeapplication.Entity.Joke;
import com.example.Jokeapplication.Repository.JokeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JokeService {

	private final RestTemplate restTemplet;
	private final JokeRepository jokeRepository;
	private final static String URL = "https://official-joke-api.appspot.com/random_joke";

	public List<Joke> getRandomJokes(int count) {
		List<Joke> jokes = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			jokes.add(restTemplet.getForObject(URL, Joke.class));
		}

		return jokes;
	}

	public String addJoke(Joke joke) {
		jokeRepository.save(joke);
		return "Joke added successfully";
	}

}
