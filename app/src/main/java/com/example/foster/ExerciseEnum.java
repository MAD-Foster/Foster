package com.example.foster;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum ExerciseEnum {
    BEGINNER_DAY_1("Jumping jacks", " Push-ups", "Lunges", " Plank", "Bicycle crunches"),
    BEGINNER_DAY_2("Squats", " Triceps dips", "Burpees", "Side plank", " High knees"),
    BEGINNER_DAY_3("Box jumps", " Step-ups", " Russian twists", " Leg raises"),
    BEGINNER_DAY_4("Push-ups", " Squats", " Sit-ups", " Mountain climbers"),
    BEGINNER_DAY_5("Plyometric jumps", "Reverse crunches", " Heel touches", " Leg raises"),
    BEGINNER_DAY_6("Jumping jacks", " Push-ups", "Lunges", "Plank ups", " Side plank dips"),
    BEGINNER_DAY_7("Bicycle crunches"," Lunges"," Russian twists"," Triceps Dips"," Push-ups "),

    INTERMEDIATE_DAY_1("Push-ups"," Bench press"," Lat pulldowns"," Tricep dips"," Bicep curls"),
    INTERMEDIATE_DAY_2("Squats"," Lunges", "Leg press"," Leg curls", "Calf raises"),
    INTERMEDIATE_DAY_3("Burpees"," Box jumps"," High knees"," Mountain climbers"," Tuck jumps"),
    INTERMEDIATE_DAY_4("Deadlifts"," Step-ups"," Glute bridges"," Hip thrusts"," Plank"),
    INTERMEDIATE_DAY_5("Push-ups"," Bench press"," Lat pulldowns"," Tricep dips", "Bicep curls"),
    INTERMEDIATE_DAY_6("Squats"," Lunges"," Leg press"," Leg curls"," Calf raises"),
    INTERMEDIATE_DAY_7("Burpees"," Box jumps", "High knees", "Mountain climbers"," Tuck jumps"),

    EXPERT_DAY_1("Plyometric push-ups"," Bench press"," Lat pulldowns"," Tricep dips"," Bicep curls"),
    EXPERT_DAY_2("Squats, Lunges"," Leg press"," Leg curls", "Calf raises"),
    EXPERT_DAY_3("Burpees", "Box jumps"," High knees"," Mountain climbers"," Tuck jumps"),
    EXPERT_DAY_4("Deadlifts"," Step-ups"," Glute bridges"," Hip thrusts"," Plank"),
    EXPERT_DAY_5("Plyometric push-ups"," Bench press"," Lat pulldowns"," Tricep dips"," Bicep curls"),
    EXPERT_DAY_6("Squats, Lunges", "Leg press", "Leg curls", "Calf raises"),
    EXPERT_DAY_7("Burpees"," Box jumps"," High knees"," Mountain climbers"," Tuck jumps"),

    FATLOSS_DAY_1("Jumping jacks", "High knees", "Butt kicks"," Plank jacks", "Side shuffles"),
    FATLOSS_DAY_2("Mountain climbers", "Squat jumps"," Lunges"," Skaters"," Burpees"),
    FATLOSS_DAY_3("Tuck jumps"," Box jumps"," Star jumps"," Jump rope"," Butt kicks"),
    FATLOSS_DAY_4("High knees", "Jumping jacks", "Power skips", "Plank jacks"," Side shuffles"),
    FATLOSS_DAY_5("Squat jumps"," Lunges"," Mountain climbers"," Skaters,Burpees"),
    FATLOSS_DAY_6("Box jumps"," Tuck jumps"," Star jumps"," Jump rope"," Butt kicks"),
    FATLOSS_DAY_7("High knees"," Jumping jacks"," Power skips"," Plank jacks"," Side shuffles");

    private final Map<String,String> exercises;

    ExerciseEnum(String... exercises) {
        this.exercises = new LinkedHashMap<>();
        for(String name:exercises){
            System.out.println("enum "+name);
            this.exercises.put(name,name);
        }
    }

    public Map<String,String> getExercises(){
        return this.exercises;
    }
}
