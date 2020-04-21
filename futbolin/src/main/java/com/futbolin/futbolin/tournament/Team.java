package com.futbolin.futbolin.tournament;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Team
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Long player1;
    private Long player2;
    private Long tournament;

    public Team(final long id, final String name, final Long player1, final Long player2, final Long tournament)
    {
        this(name, player1, player2, tournament);
        this.id = id;
    }

    public Team(final String name, final Long player1, final Long player2, final Long tournament)
    {
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
        this.tournament = tournament;
    }

    public Team() {}

    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Long getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(final Long player1)
    {
        this.player1 = player1;
    }

    public Long getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(final Long player2)
    {
        this.player2 = player2;
    }

    public Long getTournament()
    {
        return tournament;
    }

    public void setTournament(final Long tournament)
    {
        this.tournament = tournament;
    }
}