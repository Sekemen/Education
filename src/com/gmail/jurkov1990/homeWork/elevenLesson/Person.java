package com.gmail.jurkov1990.homeWork.elevenLesson;

public class Person {
    private String name;
    private int age;
    private String profession;

    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void displayInfo() {
        System.out.printf("Ім'я: %s, Вік: %d, Професія: %s\n", name, age, profession);
    }
}