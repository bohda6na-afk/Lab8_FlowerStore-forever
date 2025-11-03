package ua.edu.ucu.apps.lab8.model;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket extends Item {
    private List<Flower> flowers = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    @Override
    public double price() {
        return flowers.stream()
                .mapToDouble(Flower::getPrice)
                .sum();
    }

    @Override
    public String getDescription() {
        return "Flower bucket with " + flowers.size() + " flowers";
    }
}
