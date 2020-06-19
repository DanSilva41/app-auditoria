package br.com.silva.app.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "dominio", name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false, length = 80)
    private String titulo;

    @Column(nullable = false, length = 60)
    private String autor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produtor_id", nullable = false)
    private Produtor produtor;
}
