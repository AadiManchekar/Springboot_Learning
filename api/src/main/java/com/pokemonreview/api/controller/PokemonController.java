package com.pokemonreview.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonreview.api.models.Pokemon;

@RestController
@RequestMapping("api/v1")
public class PokemonController {

    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Charizad", "Fire"));
        pokemons.add(new Pokemon(2, "Pikachu", "Electric"));
        pokemons.add(new Pokemon(3, "Alakazam", "Phsycic"));
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Integer id) {
        return ResponseEntity.ok(new Pokemon(id, "Charizad", "Fire"));
    }

    @PostMapping("pokemon")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        System.out.println(pokemon);
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") Integer pokemonId) {
        System.out.println(pokemon);
        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("pokemon/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") Integer pokemonId) {
        System.out.println(pokemonId);
        return ResponseEntity.ok("success");
    }
}
