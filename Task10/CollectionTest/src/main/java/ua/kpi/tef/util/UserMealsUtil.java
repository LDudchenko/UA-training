package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        List<UserMealWithExceed> userMealWithExceedList = getFilteredWithExceededUsingJava6(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        System.out.println("Solving task using Java6:");
        System.out.println(userMealWithExceedList);
        System.out.println();


        userMealWithExceedList = getFilteredWithExceededUsingJava8(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        System.out.println("Solving task using Java8:");
        System.out.println(userMealWithExceedList);
    }

    public static List<UserMealWithExceed> getFilteredWithExceededUsingJava6(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> userMealWithExceedList = new ArrayList<>();
        Map<LocalDate, Integer> items = new HashMap<>();

        for (UserMeal meal : mealList) {
            if (items.get(meal.getDateTime().toLocalDate()) == null) {
                items.put(meal.getDateTime().toLocalDate(), meal.getCalories());
            } else {
                items.computeIfPresent(meal.getDateTime().toLocalDate(), (key, value) -> value + meal.getCalories());
            }
        }
        
        for (UserMeal meal : mealList) {
            if (TimeUtil.isBetween(meal.getDateTime().toLocalTime(), startTime, endTime)) {
                userMealWithExceedList.add(new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(), caloriesPerDay - items.getOrDefault(meal.getDateTime().toLocalDate(), 0) < 0));
            }
        }

        return userMealWithExceedList;
    }

    public static List<UserMealWithExceed> getFilteredWithExceededUsingJava8(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> userMealWithExceedList;
        Map<LocalDate, Integer> items2 = new HashMap<>();

        mealList.stream().map(meal -> {
            if (items2.get(meal.getDateTime().toLocalDate()) == null) {
                items2.put(meal.getDateTime().toLocalDate(), meal.getCalories());
                return meal;
            } else {
                items2.computeIfPresent(meal.getDateTime().toLocalDate(), (key, value) -> value + meal.getCalories());
                return meal;
            }
        }).collect(Collectors.toList());

        Map<UserMeal, UserMealWithExceed> tempMap = mealList.stream().filter(x -> TimeUtil.isBetween(x.getDateTime().toLocalTime(), startTime, endTime)).collect(Collectors.toMap(x -> x, x -> new UserMealWithExceed(x.getDateTime(), x.getDescription(), x.getCalories(), caloriesPerDay - items2.getOrDefault(x.getDateTime().toLocalDate(), 0) < 0)));
        userMealWithExceedList = new ArrayList<>(tempMap.values());

        return userMealWithExceedList;
    }
}
