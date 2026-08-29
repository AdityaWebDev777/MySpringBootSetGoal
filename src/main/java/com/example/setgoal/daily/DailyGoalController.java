package com.example.setgoal.daily;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/daily-goals")
public class DailyGoalController {

    private final DailyGoalService dailyGoalService;

    public DailyGoalController(DailyGoalService dailyGoalService) {
        this.dailyGoalService = dailyGoalService;
    }

    @PostMapping
    public DailyGoal save(@Valid @RequestBody DailyGoalRequest request) {
        return dailyGoalService.upsert(request);
    }

    @GetMapping
    public List<DailyGoal> list(
            @RequestParam(defaultValue = "1970-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(defaultValue = "2999-12-31") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        return dailyGoalService.findByDateRange(fromDate, toDate);
    }
}
