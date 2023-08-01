package com.pokemonreview.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.dto.PokmeonDto;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.services.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokmeonDto createPokmeonDto(PokmeonDto pokmeonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokmeonDto.getName());
        pokemon.setType(pokmeonDto.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokmeonDto pokemonResponse = new PokmeonDto();
        pokemonResponse.setId(pokemon.getId());
        pokemonResponse.setName(pokemon.getName());
        pokemonResponse.setType(pokemon.getType());

        return pokemonResponse;
    }

}
