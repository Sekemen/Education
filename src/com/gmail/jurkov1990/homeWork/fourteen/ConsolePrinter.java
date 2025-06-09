package com.gmail.jurkov1990.homework.fourteen;

public class ConsolePrinter implements Printer {

    public static class Message {
        private String text;
        private String sender;

        public Message(String text, String sender) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Override
    public void print(Message message) {
        if (isNullOrEmpty(message.getSender()) && isNullOrEmpty(message.getText())) {
            new Object() {
                void handleEmpty() {
                    System.out.println("Опрацьовується пусте повідомлення від анонімного користувача...");
                }
            }.handleEmpty();
        } else if (isNullOrEmpty(message.getSender())) {
            System.out.printf("Анонімний користувач відправив повідомлення: %s%n", message.getText());
        } else {
            System.out.printf("Користувач %s відправив повідомлення: %s%n", message.getSender(), message.getText());
        }
    }
} 