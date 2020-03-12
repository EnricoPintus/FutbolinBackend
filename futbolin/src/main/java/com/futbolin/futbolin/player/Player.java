package com.futbolin.futbolin.player;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Player
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Date date;
    private boolean finished;

    public Player() {}

    public Player(final String name, final Date date)
    {
        this.name = name;
        this.date = date;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(final Date date)
    {
        this.date = date;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void setFinished(final boolean finished)
    {
        this.finished = finished;
    }
}