package dev.simon.runTrack.run;

import java.time.LocalDateTime;

public record Run(
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Location location
) {

    public Run {
        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Run must be completed after it has started");
        }
    }
}