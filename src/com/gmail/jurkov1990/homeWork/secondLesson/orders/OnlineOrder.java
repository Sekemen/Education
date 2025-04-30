package com.gmail.jurkov1990.homeWork.secondLesson.orders;

public class OnlineOrder {
    public static void main(String[] args) {
        String order1Client = "Alice";
        String order1Product = "smartphone";
        double order1Price = 305.99;
        String order1Address = "Moon Street, 10";

        String order2Client = "Tom";
        String order2Product = "laptop";
        double order2Price = 570.95;
        String order2Address = "Terra Street, 17";

        System.out.println("Order No 1 Client: " + order1Client + ".");
        System.out.println("Product: " + order1Product + ",");
        System.out.println("price EUR " + order1Price + ".");
        System.out.println("Address: " + order1Address + ".");

        System.out.println("Order No 2 Client: " + order2Client + ".");
        System.out.println("Product: " + order2Product + ",");
        System.out.println("price EUR " + order2Price + ".");
        System.out.println("Address: " + order2Address + ".");
    }
}