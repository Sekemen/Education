package com.gmail.jurkov1990.homework.fourteen;

public class PrinterLauncher {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();

        System.out.println("--- message with sender ---");
        ConsolePrinter.Message messageWithSender = new ConsolePrinter.Message("Hello world!", "Andrii");
        printer.print(messageWithSender);

        System.out.println("--- message with null sender ---");
        ConsolePrinter.Message messageAndNullSender = new ConsolePrinter.Message("Some message with null sender", null);
        printer.print(messageAndNullSender);

        System.out.println("--- message with empty sender ---");
        ConsolePrinter.Message messageAndEmptySender = new ConsolePrinter.Message("Some message with empty sender", "");
        printer.print(messageAndEmptySender);

        System.out.println("--- null message and null sender ---");
        ConsolePrinter.Message nullAndNull = new ConsolePrinter.Message(null, null);
        printer.print(nullAndNull);
        
        System.out.println("--- empty message and empty sender ---");
        ConsolePrinter.Message emptyAndEmpty = new ConsolePrinter.Message("", "");
        printer.print(emptyAndEmpty);

        System.out.println("--- null message with sender ---");
        ConsolePrinter.Message nullWithSender = new ConsolePrinter.Message(null, "QA Engineer");
        printer.print(nullWithSender);
    }
} 