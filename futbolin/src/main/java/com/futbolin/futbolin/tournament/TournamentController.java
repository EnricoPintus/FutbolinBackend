package com.futbolin.futbolin.tournament;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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
    private final TournamentRepositoryInterface repository;

    TournamentController(TournamentRepositoryInterface repository) {
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
    EntityModel<Tournament> one(@PathVariable Long id) {
        Tournament tournament = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));

        return new EntityModel<>(tournament,
            linkTo(methodOn(TournamentController.class).one(id)).withSelfRel());
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

    @PutMapping("/tournaments/{id}/generateTeams")
    void generateTeams(@RequestBody GenerateTeamsParameterRest teamsParameterRest,
                       @PathVariable Long id)
    {
        int a = 1;
    }
    @GetMapping("/tournaments/{id}/teams")
    void getTeams(@PathVariable Long id) {};
}

