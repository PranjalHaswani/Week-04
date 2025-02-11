package com.day1.generics;

import java.util.ArrayList;
import java.util.List;

// Interface representing a Meal Plan
interface MealPlan {
    String getMealType();
}

// Specific meal plan categories
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }
}

// Generic class for handling meal plans
class Meal<T extends MealPlan> {
    private String mealName;
    private List<String> ingredients;
    private T mealType;

    public Meal(String mealName, List<String> ingredients, T mealType) {
        this.mealName = mealName;
        this.ingredients = ingredients;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return mealName + " (" + mealType.getMealType() + "): " + ingredients;
    }
}

// Meal Plan Generator
class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> meals = new ArrayList<>();

    public void addMeal(Meal<? extends MealPlan> meal) {
        meals.add(meal);
    }

    public void showMeals() {
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println(meal);
        }
    }

    // Generic method to validate and generate a meal plan
    public static <T extends MealPlan> void generatePersonalizedMeal(Meal<T> meal) {
        System.out.println("Generating meal plan: " + meal.getMealName() + " (" + meal.getMealType().getMealType() + ")");
    }
    public List<Meal<? extends MealPlan>> getMealList() {
        return meals;
    }

}

// Main class
public class MealPlanner {
    public static void main(String[] args) {
        MealPlanGenerator mealPlanGenerator = new MealPlanGenerator();

        // Creating meal plans
        Meal<VegetarianMeal> vegMeal = new Meal<>(
                "Vegetable Stir-Fry",
                List.of("Carrots", "Broccoli", "Tofu", "Soy Sauce"),
                new VegetarianMeal()
        );

        Meal<VeganMeal> veganMeal = new Meal<>(
                "Quinoa Salad",
                List.of("Quinoa", "Chickpeas", "Cucumber", "Lemon"),
                new VeganMeal()
        );

        Meal<KetoMeal> ketoMeal = new Meal<>(
                "Grilled Chicken with Avocado",
                List.of("Chicken", "Avocado", "Olive Oil", "Garlic"),
                new KetoMeal()
        );

        Meal<HighProteinMeal> proteinMeal = new Meal<>(
                "Egg and Spinach Omelette",
                List.of("Eggs", "Spinach", "Cheese", "Olive Oil"),
                new HighProteinMeal()
        );

        // Adding meals to the meal plan generator
        mealPlanGenerator.addMeal(vegMeal);
        mealPlanGenerator.addMeal(veganMeal);
        mealPlanGenerator.addMeal(ketoMeal);
        mealPlanGenerator.addMeal(proteinMeal);

        // Display available meals
        System.out.println("Available Meal Plans:");
        mealPlanGenerator.showMeals();

        // Generate personalized meal plans
        MealPlanGenerator.generatePersonalizedMeal(vegMeal);
        MealPlanGenerator.generatePersonalizedMeal(veganMeal);
        MealPlanGenerator.generatePersonalizedMeal(ketoMeal);
        MealPlanGenerator.generatePersonalizedMeal(proteinMeal);
    }
}