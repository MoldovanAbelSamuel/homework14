package org.fasttrack;

import java.util.*;

public class QuoteService {


    private List<Quote> quotes;

    private List<Quote> favorites;

    public QuoteService(List<String> textFile) {
        quotes = new ArrayList<>();
        for (int i = 0 ; i<textFile.size(); i++){
            String[] authorContent = textFile.get(i).split("~");
            Quote newQuote = new Quote(i+1,authorContent[0], authorContent[1], false);
            quotes.add(newQuote);
        }
        this.favorites = new ArrayList<>();
    }

    public List<String> getAllQuotes (){
        List<String> allQuotes = new ArrayList<>();
        for (Quote currentLine : this.quotes){
            allQuotes.add(currentLine.getQuote());
        }
        return allQuotes;
    }

    public List<Quote> getQuotesForAuthor (String author){
        List<Quote> allQuotes = new ArrayList<>();
        for (Quote currentLine : this.quotes){
            if (Objects.equals(currentLine.getAuthor(), author)){
                allQuotes.add(currentLine);
            }
        }
        return allQuotes;
    }

    public List<String> getAuthors (){
        Set<String> unique = new HashSet<>();
        for (Quote currentLine : this.quotes){
            unique.add(currentLine.getAuthor());
        }
        return unique.stream().toList();
    }

    public void setFavourite (int id) {
        Quote favorite = this.quotes.get(id - 1);
        favorite.setFavourite(true);
        this.favorites.add(favorite);
    }

    public List<Quote> getFavorites (){
        return this.favorites;
    }

    public String getRandomQuote (){
        Random random = new Random();
        int randomPosition = random.nextInt(this.quotes.size());
        Quote randomQuote = this.quotes.get(randomPosition);
        return randomQuote.getId() + " " + randomQuote.getQuote() + "\n";
    }
}
