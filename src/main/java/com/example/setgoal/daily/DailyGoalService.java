package com.example.setgoal.daily;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DailyGoalService {

    private final DailyGoalRepository dailyGoalRepository;

    public DailyGoalService(DailyGoalRepository dailyGoalRepository) {
        this.dailyGoalRepository = dailyGoalRepository;
    }

    public DailyGoal upsert(DailyGoalRequest request) {
        DailyGoal dailyGoal = dailyGoalRepository.findByGoalDate(request.goalDate())
                .map(existing -> {
                    existing.setGoal(request.goal());
                    existing.setCompleted(request.completed());
                    return existing;
                })
                .orElseGet(() -> new DailyGoal(request.goalDate(), request.goal(), request.completed()));
        return dailyGoalRepository.save(dailyGoal);
    }

    public List<DailyGoal> findByDateRange(LocalDate fromDate, LocalDate toDate) {
        return dailyGoalRepository.findAllByGoalDateBetweenOrderByGoalDateAsc(fromDate, toDate);
    }
}
