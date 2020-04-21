package com.futbolin.futbolin.tournament;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


public class TournamentService
{
    @Autowired
    private TeamRepositoryInterface teamRepository;

    public void generateTeamsForTournament(final Long tournamentId,
                               final GenerateTeamsParameterRest generateTeamsParameterRest)
    {
        final Long[] selectedPlayers = generateTeamsParameterRest.selectedPlayers;
        final Map<String, Long[]> alreadyAssignedTeams = generateTeamsParameterRest.teamForPlayers;
        final int teamsNumber = selectedPlayers.length / 2;


    }
}
