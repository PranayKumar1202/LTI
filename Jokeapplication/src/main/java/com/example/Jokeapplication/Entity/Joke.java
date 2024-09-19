package com.example.Jokeapplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Joke {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String setUp;
	private String type;
	private String punchine;

}
