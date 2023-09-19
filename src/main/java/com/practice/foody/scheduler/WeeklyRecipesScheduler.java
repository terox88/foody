package com.practice.foody.scheduler;

import com.practice.foody.domain.User;
import com.practice.foody.exception.BadQueryException;
import com.practice.foody.service.DbService;
import com.practice.foody.service.WeeklyRecipesCreatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class WeeklyRecipesScheduler {
    private final DbService dbService;
    private final WeeklyRecipesCreatorService weeklyRecipesCreatorService;
@Scheduled(cron = "0 0 3 * * *" )
    public void weeklyRecipesCreation() {
        log.info("\nStarting recipes creation");
        List<User> users = dbService.getUsers();
        int weeklySize;
        int index;
        for (User user : users) {
            weeklySize = user.getWeeklyRecipes().size();
            if (weeklySize == 0) {
                try {
                    weeklyRecipesCreatorService.createWeeklyRecipes(user, LocalDate.now().plusDays(2));
                    log.info("\nWeekly recipes were created for user with ID: " + user.getId());
                } catch (BadQueryException e) {
                    log.info("Cannot create weekly recipes for User with ID: " + user.getId());
                }
            } else {
                index = weeklySize > 1 ? weeklySize - 1 : 0;
                if (user.getWeeklyRecipes().get(index).getWeekEnd().isBefore(LocalDate.now().plusDays(3))) {
                    try {
                        weeklyRecipesCreatorService.createWeeklyRecipes(user, LocalDate.now().plusDays(2));
                        log.info("\nWeekly recipes were created for User with ID: " + user.getId());
                    } catch (BadQueryException e) {
                        log.info("Cannot create weekly recipes for User with ID: " + user.getId());

                    }
                }


            }
        }
    }
}
