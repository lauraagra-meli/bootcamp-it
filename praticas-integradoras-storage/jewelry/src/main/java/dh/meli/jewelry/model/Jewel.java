package dh.meli.jewelry.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@Entity
@Table(name = "tb_jewel")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private int carats; // quilates
}
