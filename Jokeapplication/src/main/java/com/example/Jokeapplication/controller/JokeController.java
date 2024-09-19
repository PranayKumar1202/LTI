package com.example.Jokeapplication.controller;

import java.util.List;

import com.example.Jokeapplication.Entity.Joke;
import com.example.Jokeapplication.service.JokeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("jokes")
public class JokeController {

	private final JokeService jokeService;

	@GetMapping()
	public ResponseEntity<List<Joke>> getMethodName(@RequestParam int count) {
		return new ResponseEntity<>(jokeService.getRandomJokes(count), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<String> addJoke(@RequestBody Joke joke) {
		return new ResponseEntity<>(jokeService.addJoke(joke), HttpStatus.CREATED);
	}