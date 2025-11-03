package ua.edu.ucu.apps.lab8.repository;
import ua.edu.ucu.apps.lab8.model.Flower;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {

    

}
