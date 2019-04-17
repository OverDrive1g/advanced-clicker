package com.example.myapplication;

public class Upgrade extends BaseUpgrade {

    private String name;
    private String description;
    private int imageId;

    public Upgrade(String name, String description, int imageId, double basePrice, double multiplier) {
        super(basePrice, multiplier, 0);
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
