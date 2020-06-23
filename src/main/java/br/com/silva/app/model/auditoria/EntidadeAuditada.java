package br.com.silva.app.model.auditoria;

import br.com.silva.app.config.AuditoriaListener;
import br.com.silva.app.model.seguranca.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "info_auditoria", schema = "auditoria")
@RevisionEntity(AuditoriaListener.class)
public class EntidadeAuditada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    private int id;

    @RevisionTimestamp
    private Date dataModificacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seq_usuario")
    private Usuario usuarioResponsavel;

}
