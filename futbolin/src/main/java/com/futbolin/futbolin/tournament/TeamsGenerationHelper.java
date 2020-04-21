package com.futbolin.futbolin.tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class TeamsGenerationHelper
{

    static final String TEAM_NAME_PREFIX = "Team ";

    private class GeneratedTeam
    {
        GeneratedTeam(int teamId) { this.teamId = teamId; }
        public int teamId;
        public Long player1;
        public Long player2;

        public boolean isCompleted() { return player1 != null && player2 != null; }
    }

    List<Team> generateTeams(Long[] selectedPlayers,
                                    Map<String, Long[]> alreadyAssignedTeams)
    {
        List<Team> teams = new ArrayList<>();
        Random rand = new Random();
        List<Long> selectedPlayersList = Arrays.asList(selectedPlayers);

        //initialize empty teams in the generated list
        Map<Integer, GeneratedTeam> mapGeneratedTeams = new HashMap<>();
        for(int i = 1; i <= selectedPlayers.length /2; i++)
        {
            mapGeneratedTeams.put(i, new GeneratedTeam(i));
        }

        // fill the generatedTeamsMap with the players already assigned to a team
        for (String team : alreadyAssignedTeams.keySet())
        {
            int teamNumber = Integer.parseInt(team.split(TEAM_NAME_PREFIX)[1]);
            if (mapGeneratedTeams.containsKey(teamNumber))
            {
                GeneratedTeam generatedTeam = mapGeneratedTeams.get(teamNumber);

                if (alreadyAssignedTeams.get(team).length >= 1) {
                    generatedTeam.player1 = alreadyAssignedTeams.get(team)[0];
                    selectedPlayersList.removeIf(player -> (player == generatedTeam.player1));
                }

                if (alreadyAssignedTeams.get(team).length == 2) {
                    generatedTeam.player2 = alreadyAssignedTeams.get(team)[1];
                    selectedPlayersList.removeIf(player -> (player == generatedTeam.player2));
                }

                mapGeneratedTeams.replace(teamNumber, generatedTeam);
            }
        }

        //fill randomly the free spaces in the generated teams
        for (GeneratedTeam generatedTeam : mapGeneratedTeams.values()){
            if (!generatedTeam.isCompleted()){
                if (generatedTeam.player1 == null){
                    generatedTeam.player1 = selectedPlayersList.get(rand.nextInt(selectedPlayersList.size()));
                    selectedPlayersList.removeIf(player -> (player == generatedTeam.player1));
                }
                if (generatedTeam.player2 == null){
                    generatedTeam.player2 = selectedPlayersList.get(rand.nextInt(selectedPlayersList.size()));
                    selectedPlayersList.removeIf(player -> (player == generatedTeam.player2));
                }
            }
        }

        return  teams;
    }
}
