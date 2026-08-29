package com.example.setgoal.daily;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record DailyGoalRequest(
        @NotNull LocalDate goalDate,
        @NotBlank @Size(max = 300) String goal,
        boolean completed) {
}
