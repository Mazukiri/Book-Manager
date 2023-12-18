package com.example.lynn_books_recommendation;
//Single Pattern to store the common variables among classes
public class Data {
    private static final Data data = new Data();

    private Data(){};

    public String type;
    public Book book;

    public static Data getData(){
        return data;
    }
}
