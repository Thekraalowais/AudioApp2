package com.example.thekra.audioapp;

public class Audio {
    private int aImage = No_IMAGE;
    private int aTitle;
    private static final int No_IMAGE = -1;

    public Audio(int image, int title) {
        aImage = image;
        aTitle = title;

    }

    public Audio(int title) {
        aTitle = title;

    }

    public int getImage() {
        return aImage;
    }

    public int getTitle() {
        return aTitle;
    }

    public boolean hasImage() {
        return aImage != No_IMAGE;
    }

}
