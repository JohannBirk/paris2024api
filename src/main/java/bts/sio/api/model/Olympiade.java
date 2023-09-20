package bts.sio.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "olympiade")
public class Olympiade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero ;
    private Integer annee;
    private String ville ;

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

}