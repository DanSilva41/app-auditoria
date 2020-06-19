package br.com.silva.app.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "dominio", name = "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false, length = 60)
    private String titulo;

    @Column(nullable = false)
    private String letra;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;
}
