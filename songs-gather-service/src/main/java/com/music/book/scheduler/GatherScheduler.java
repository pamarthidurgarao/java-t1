package com.music.book.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.music.book.service.SongGatherService;

@Component
public class GatherScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(GatherScheduler.class);

    @Autowired
    private SongGatherService gatherService;

    @Scheduled(cron = "0 7 * * *")
    public void run() {
	LOG.info("Data gather scheduler triggered");
	try {
	    gatherService.cacheMovies();
	} catch (Exception e) {
	    LOG.info("Failed to fetch the data {}", e.getMessage());
	}
	LOG.info("Successfully run the Data gather");
    }

}
// https://crontab.guru/#0_7_*_*_*