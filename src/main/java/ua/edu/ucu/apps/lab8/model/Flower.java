package ua.edu.ucu.apps.lab8.model;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flowers")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flowertype")
    private String flowerType;
    @Column(name = "flowercolor")
    private String flowerColor;
    private double price;
    private boolean available;

}
