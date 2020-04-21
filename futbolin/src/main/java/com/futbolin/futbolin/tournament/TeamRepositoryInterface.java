package com.futbolin.futbolin.tournament;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepositoryInterface extends JpaRepository<Tournament, Long>
{
    void addTeamToTournament();
}