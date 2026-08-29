package com.example.setgoal.daily;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyGoalRepository extends JpaRepository<DailyGoal, Long> {
    List<DailyGoal> findAllByGoalDateBetweenOrderByGoalDateAsc(LocalDate startDate, LocalDate endDate);

    Optional<DailyGoal> findByGoalDate(LocalDate goalDate);
}
