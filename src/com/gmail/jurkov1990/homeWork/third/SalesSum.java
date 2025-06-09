package com.gmail.jurkov1990.homework.third;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesSum {
    public static void main(String[] args) {
        String productName;
        int productNumber = 0;
        BigDecimal unitPrice;
        int quantity;
        int salesDays;
        BigDecimal totalSales;
        BigDecimal salesPerDay;

        productName = "smartphone";
        unitPrice = new BigDecimal("2430.68");
        quantity = 5;
        salesDays = 5;

        totalSales = unitPrice.multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP);
        salesPerDay = totalSales.divide(new BigDecimal(salesDays), 2, RoundingMode.HALF_UP);
        // пацани з білінга сказали шо якшо про грощі і в джаві то отак треба
        // я сам написав отак
        //totalSales = Math.round(unitPrice * quantity * 100.0) / 100.0;
        //salesPerDay = Math.round(totalSales / salesDays * 100.0) / 100.0;



        System.out.printf("Product No %d: %s,%n", ++productNumber, productName);
        System.out.printf("total sales for %d days is EUR %.2f,%n", salesDays, totalSales);
        System.out.printf("sales by day is EUR %.2f.%n", salesPerDay);

        productName = "laptop";
        unitPrice = new BigDecimal("1498.12");
        quantity = 7;
        salesDays = 7;

        totalSales = unitPrice.multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP);
        salesPerDay = totalSales.divide(new BigDecimal(salesDays), 2, RoundingMode.HALF_UP);

        System.out.printf("Product No %d: %s,%n", ++productNumber, productName);
        System.out.printf("total sales for %d days is EUR %.2f,%n", salesDays, totalSales);
        System.out.printf("sales by day is EUR %.2f.%n", salesPerDay);
    }
}