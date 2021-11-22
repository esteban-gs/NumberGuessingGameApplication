package com.esteban_edu.NumberGuessingGame.utils;

public class Utils {
    public static void log(String message, String label) {
        System.out.println(
                ConsoleColors.PURPLE_BOLD + label + ": " + ConsoleColors.RESET +
                ConsoleColors.CYAN_BOLD + message + ConsoleColors.RESET);
    }

    public static void log(int message, String label) {
        System.out.println(
                ConsoleColors.PURPLE_BOLD + label + ": " + ConsoleColors.RESET +
                ConsoleColors.CYAN_BOLD + message + ConsoleColors.RESET);
    }

    public static void log(Long message, String label) {
        System.out.println(
                ConsoleColors.PURPLE_BOLD + label + ": " + ConsoleColors.RESET +
                ConsoleColors.CYAN_BOLD + message + ConsoleColors.RESET);
    }

    public static void log(boolean message, String label) {
        System.out.println(
                ConsoleColors.PURPLE_BOLD + label + ": " + ConsoleColors.RESET +
                ConsoleColors.CYAN_BOLD + message + ConsoleColors.RESET);
    }

    public static void log(double message, String label) {
        System.out.println(
                ConsoleColors.PURPLE_BOLD + label + ": " + ConsoleColors.RESET +
                ConsoleColors.CYAN_BOLD + message + ConsoleColors.RESET);
    }

    public static void log(char message, String label) {
        System.out.println(
                ConsoleColors.PURPLE_BOLD + label + ": " + ConsoleColors.RESET +
                ConsoleColors.CYAN_BOLD + message + ConsoleColors.RESET);
    }

    public static void log(StringBuilder message, String label) {
        System.out.println(
                ConsoleColors.PURPLE_BOLD + label + ": " + ConsoleColors.RESET +
                ConsoleColors.CYAN_BOLD + message + ConsoleColors.RESET);
    }
}
