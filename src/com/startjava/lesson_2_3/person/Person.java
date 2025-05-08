package com.startjava.lesson_2_3.person;

class Person {
    private String gender;
    private String name;
    private int height;
    private int weight;
    private int age;

    {
        gender = "male";
        name = "Vlad";
        height = 170;
        weight = 95;
        age = 35;
    }

    public void beginMovement() { 
        System.out.println("Я иду");
    }

    public void sit() {
        System.out.println("Я сижу");
    }

    public void run() {
        System.out.println("Я бегу");
    }

    public void speak() {
        System.out.println("Я говорю");
    }

    public void learnJava() {
        System.out.println("я учу Java");
    }
}
