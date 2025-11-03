package ua.edu.ucu.apps.lab8.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import ua.edu.ucu.apps.lab8.model.Flower;
import ua.edu.ucu.apps.lab8.service.FlowerService;

@RestController
@RequestMapping("/api/v1")
public class FlowerController {

    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping("/flower")
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @PostMapping("/flower")
    public Flower createFlower(@RequestBody Flower flower) {
        return flowerService.createFlower(flower);
    }
}
