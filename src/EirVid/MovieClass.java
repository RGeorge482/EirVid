package EirVid;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author ignacioalarconvarela
 * 2021357
 */
public class MovieClass {
    private String original_language;
    private String title;
    private double popularity;
    private double vote_average;
    private int vote_count;
    private double price;

    public MovieClass(String original_language, double popularity, String title, double vote_average, int vote_count, double price) {
        this.original_language = original_language;
        this.popularity = popularity;
        this.title = title;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.price = price;
    }
    
    public MovieClass(){
    };
    
     // Getters
    public String getOriginalLanguage() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public int getVoteCount() {
        return vote_count;
    }

    public double getPrice() {
        return price;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return "Movies: {" + "original_language=" + original_language + ", title=" + title + ", popularity=" + popularity + ", vote_average=" + vote_average + ", vote_count=" + vote_count + ", price=" + price + '}';
    }
}