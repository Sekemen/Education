package com.gmail.jurkov1990.homeWork.elevenLesson;


import java.util.ArrayList;
import java.util.List;

public class PersonDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", 30, "Інженер"));
        people.add(new Person("Mary", 25, "Вчитель"));
        people.add(new Person("Bob", 35, "Лікар"));
        people.add(new Person("Alice", 28, "Архітектор"));

        System.out.println("Інформація про всіх осіб:");
        displayAllUsersInfo(people);

        System.out.println("\nЗміна професії для " + people.get(3).getName() + ":");
        System.out.printf("Поточна професія: %s\n", people.get(3).getProfession());
        people.get(3).setProfession("Дизайнер");
        System.out.printf("Нова професія: %s\n", people.get(3).getProfession());

        System.out.println("\nОновлена інформація:");
        displayAllUsersInfo(people);
    }

    private static void displayAllUsersInfo(List<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            people.get(i).displayInfo();
        }
    }
}