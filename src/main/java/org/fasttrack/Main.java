package org.fasttrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> allText = FormatFile.readFile("C:\\Users\\loren\\IdeaProjects\\Homework14\\src\\main\\java\\textFiles\\quotes.txt");
        QuoteService quoteService = new QuoteService(allText);

        List<String> firstExercises = quoteService.getAllQuotes();
        for (String currentLine : firstExercises){
            System.out.println(currentLine);
        }

        System.out.println("\n");

        List<Quote> secondExercises = quoteService.getQuotesForAuthor("unknown");
        for (Quote currentLine : secondExercises){
            System.out.println(currentLine);
        }

        System.out.println("\n");

        List<String> thirdExercises = quoteService.getAuthors();
        for (String currentLine : thirdExercises){
            System.out.println(currentLine);
        }

        System.out.println("\n");

        quoteService.setFavourite(15);
        quoteService.setFavourite(678);
        quoteService.setFavourite(1111);
        quoteService.setFavourite(54);
        quoteService.setFavourite(3465);

        List<Quote> fourExercises = quoteService.getFavorites();
        for (Quote currentLine : fourExercises){
            System.out.println(currentLine);
        }

        System.out.println("\n");

        System.out.println(quoteService.getRandomQuote());
    }
}