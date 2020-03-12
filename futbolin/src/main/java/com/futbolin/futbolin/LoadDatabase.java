package com.futbolin.futbolin;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.futbolin.futbolin.tournament.Tournament;
import com.futbolin.futbolin.tournament.TournamentRepository;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class LoadDatabase
{
    Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(TournamentRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Tournament("Torneo 1", new Date())));
            log.info("Preloading " + repository.save(new Tournament("Torneo 2", new Date())));
        };
    }
}
