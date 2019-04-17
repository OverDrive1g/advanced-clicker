package com.example.myapplication;

public class Storage {
    private static Storage storage;

    public double score = 0.0;


    public static Storage getStorage(){
        if(storage != null){
            return storage;
        }
        else {
            storage = new Storage();
            return storage;
        }
    }

}
