package br.com.silva.app.model.seguranca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "seguranca", name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_usuario", nullable = false)
    private Integer seqUsuario;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username", length = 30, unique = true, nullable = false)
    private String username;

    @NotNull
    @Size(min = 6, max = 60)
    @Column(name = "senha", length = 60)
    private String senha;

}
