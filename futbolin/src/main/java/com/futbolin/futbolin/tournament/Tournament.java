package com.futbolin.futbolin.tournament;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Date date;
    private String status;

    public Tournament() {}

    public Tournament(final String name, final Date date)
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(final String status)
    {
        this.status = status;
    }
}