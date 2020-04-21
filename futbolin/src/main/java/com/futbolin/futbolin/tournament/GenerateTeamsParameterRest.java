package com.futbolin.futbolin.tournament;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class GenerateTeamsParameterRest
{

    public Long[] selectedPlayers;
    public Map<String, Long[]> teamForPlayers;

    public GenerateTeamsParameterRest() {}

    public GenerateTeamsParameterRest(final Long[] selectedPlayers, Map<String, Long[]> teamForPlayers)
    {
        this.selectedPlayers = selectedPlayers;
        this.teamForPlayers = teamForPlayers;
    }

}