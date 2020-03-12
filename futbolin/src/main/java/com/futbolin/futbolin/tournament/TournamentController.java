package com.futbolin.futbolin.tournament;

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
public class TournamentController
{
    @Autowired
    private final TournamentRepository repository;

    TournamentController(TournamentRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/tournaments")
    List<Tournament> all() {
        return repository.findAll();
    }

    @PostMapping("/tournaments")
    Tournament newTournament(@RequestBody Tournament newTournaments) {
        return repository.save(newTournaments);
    }

    // Single item

    @GetMapping("/tournaments/{id}")
    Tournament one(@PathVariable Long id) {

        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PutMapping("/tournaments/{id}")
    Tournament replaceTournament(@RequestBody Tournament newTournament, @PathVariable Long id) {

        return repository.findById(id)
            .map(tournament -> {
                tournament.setName(newTournament.getName());
                tournament.setDate(newTournament.getDate());
                return repository.save(tournament);
            })
            .orElseGet(() -> {
                return repository.save(newTournament);
            });
    }

    @DeleteMapping("/tournaments/{id}")
    void deleteTournament(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

