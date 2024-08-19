package com.recipesns.service.food.scheduler;

import com.recipesns.service.food.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class FoodCronTable {

    private final FoodService foodService;

    @Scheduled(cron = "0 2 * * * *")
    public void mainJob() {
        try {
            log.info("배치 시작");
            foodService.updateFood(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        } catch (Exception e) {
            log.info("* Batch 시스템이 예기치 않게 종료되었습니다. Message: {}", e.getMessage());
        }
    }
}
