package ua.edu.ucu.apps.lab8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ucu.apps.lab8.model.Flower;
import java.util.List;
import ua.edu.ucu.apps.lab8.repository.FlowerRepository;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlowers() {
        return flowerRepository.findAll();
    }

    public Flower createFlower(Flower flower) {
        return flowerRepository.save(flower);
    }
}
