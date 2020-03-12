package com.futbolin.futbolin.tournament;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "tournaments", path = "tournaments")
public interface TournamentRepository extends JpaRepository<Tournament, Long>
{

    List<Tournament> findAll();

}