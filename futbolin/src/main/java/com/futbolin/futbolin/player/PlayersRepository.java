package com.futbolin.futbolin.player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "players", path = "players")
public interface PlayersRepository extends JpaRepository<Player, Long>
{
}