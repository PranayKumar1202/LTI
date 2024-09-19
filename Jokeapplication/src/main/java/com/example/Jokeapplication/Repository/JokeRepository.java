package com.example.Jokeapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Jokeapplication.Entity.Joke;

public interface JokeRepository extends JpaRepository<Joke, Integer> {

}
