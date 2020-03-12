package com.futbolin.futbolin.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerController
{
    @Autowired
    private final PlayersRepository repository;

    PlayerController(PlayersRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/tournaments")
    List<Player> all() {
        return repository.findAll();
    }

    @PostMapping("/tournaments")
    Player newTournament(@RequestBody Player newTournaments) {
        return repository.save(newTournaments);
    }

    // Single item

    @GetMapping("/tournaments/{id}")
    Player one(@PathVariable Long id) {

        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PutMapping("/tournaments/{id}")
    Player replaceTournament(@RequestBody Player newPlayer, @PathVariable Long id) {

        return repository.findById(id)
            .map(player -> {
                player.setName(newPlayer.getName());
                player.setDate(newPlayer.getDate());
                return repository.save(player);
            })
            .orElseGet(() -> {
                return repository.save(newPlayer);
            });
    }

    @DeleteMapping("/tournaments/{id}")
    void deleteTournament(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

