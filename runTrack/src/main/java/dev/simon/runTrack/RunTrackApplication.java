package dev.simon.runTrack;
import dev.simon.runTrack.run.Location;
import dev.simon.runTrack.run.Run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunTrackApplication {

	private static final Logger log = LoggerFactory.getLogger(RunTrackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunTrackApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}


}
