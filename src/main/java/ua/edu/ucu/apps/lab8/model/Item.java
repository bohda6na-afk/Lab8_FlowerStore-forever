package ua.edu.ucu.apps.lab8.model;

public abstract class Item {
    private String description;

    public abstract double price();
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}