package calculatorLogic;

import Pojo.CalculatorPojo;

import java.text.DecimalFormat;

public  class CalculateLogic {

//In this class, I created my own code flow to create the expected data using the pojo variables I set in step def and get this variables from pojo here

        private static final int CALORIES_PER_GRAM_OF_CARBS = 4;

        public static String calculateWeightMaintenanceCalories(CalculatorPojo pojo) {
            double bmr = calculateBMR(pojo.getGender(), pojo.getWeight(), pojo.getHeight(), pojo.getAge());
            double maintenanceCalories = calculateMaintenanceCalories(bmr, pojo.getActivityLevel());

            calculateCarbohydrateIntake(maintenanceCalories);
            // Create a decimal format object with comma separators
            DecimalFormat df = new DecimalFormat("#,###");

            // Format the maintenanceCalories value with commas
            String formattedMaintenanceCalories = df.format(maintenanceCalories)+" Calories";

            // Return the formatted value as a string
            return formattedMaintenanceCalories;

        }

        private static double calculateBMR(String gender, int weight, int height, int age) {
            double  bmr;
            if (gender.equalsIgnoreCase("male")) {
                //here i create this formula based on webSite information
                //Mifflin-St Jeor Equation:
                //For men:
                //BMR = 10W + 6.25H - 5A + 5
                //For women:
                //BMR = 10W + 6.25H - 5A - 161
                bmr =  (10 * weight) + (6.25 * height) - (5 * age)+5;
            } else {
                bmr =   (10 * weight) + (6.25 * height) - (5 * age)-161;
            }
            return bmr;
        }

        private static double calculateMaintenanceCalories(double bmr, String activityLevel) {
            double maintenanceCalories;
            switch (activityLevel) {
                case "Moderately Active":
                    maintenanceCalories = bmr * 1.55;
                    break;
                case "Vigorously Active":
                    maintenanceCalories = bmr * 1.725;
                    break;
                default:
                    maintenanceCalories = bmr * 1.2; // Default to sedentary
                    break;
            }
            return maintenanceCalories;
        }

        private static void calculateCarbohydrateIntake(double maintenanceCalories) {
            // Here i calculate grams also, regarding to webSite but The information of the website was not enough, 1-3 gr difference between grams
            //My aim is to show my approach here, I could write more if it was BRD

            double carbCalories40 = maintenanceCalories * 0.4;
            double carbCalories55 = maintenanceCalories * 0.55;
            double carbCalories65 = maintenanceCalories * 0.65;
            double carbCalories75 = maintenanceCalories * 0.75;

            double carbGrams40 = carbCalories40 / CALORIES_PER_GRAM_OF_CARBS;
            double carbGrams55 = carbCalories55 / CALORIES_PER_GRAM_OF_CARBS;
            double carbGrams65 = carbCalories65 / CALORIES_PER_GRAM_OF_CARBS;
            double carbGrams75 = carbCalories75 / CALORIES_PER_GRAM_OF_CARBS;

          //  System.out.printf("Daily Calorie Allowance:\n40%%: %.2f calories (%.2f grams of carbohydrates)\n", carbCalories40, carbGrams40);
          //  System.out.printf("55%%: %.2f calories (%.2f grams of carbohydrates)\n", carbCalories55, carbGrams55);
          //  System.out.printf("65%%: %.2f calories (%.2f grams of carbohydrates)\n", carbCalories65, carbGrams65);
         //   System.out.printf("75%%: %.2f calories (%.2f grams of carbohydrates)\n", carbCalories75, carbGrams75);
        }

    }







