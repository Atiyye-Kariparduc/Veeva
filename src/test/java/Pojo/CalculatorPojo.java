package Pojo;

import com.google.gson.annotations.SerializedName;
//Here I created a pojo class that I can use for API or UI testing. I manipulated variables using getter and setter methods

public class CalculatorPojo {
    public CalculatorPojo(){};
    public CalculatorPojo(int age, String gender, int height, int weight, String activityLevel) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
    }
    @SerializedName("age")
    private int age;

    @SerializedName("gender")
    private String gender;

    @SerializedName("height")
    private int height;



    @SerializedName("weight")
    private int weight;

    @SerializedName("activityLevel")
    private String activityLevel;

    @SerializedName("carbs")
    private double carbs;

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }
}

