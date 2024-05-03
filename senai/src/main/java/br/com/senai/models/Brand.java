package br.com.senai.models;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
@Getter
@Setter
@Table(name = "brand")
@Entity
@EqualsAndHashCode(of = "id")

public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //dizer que é not null é so fazer nullable = false;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
