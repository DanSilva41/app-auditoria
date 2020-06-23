package br.com.silva.app.config;

import br.com.silva.app.model.auditoria.EntidadeAuditada;
import br.com.silva.app.model.seguranca.Usuario;
import br.com.silva.app.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Optional;
import java.util.TimeZone;

@Component
@AllArgsConstructor
public class AuditoriaListener implements RevisionListener {

    private UsuarioRepository usuarioRepository;

    @Override
    public void newRevision(Object revision) {
        Usuario usuarioLogado = this.capturarUsuarioLogado();

        EntidadeAuditada entidadeAuditada = (EntidadeAuditada) revision;
        entidadeAuditada.setUsuarioResponsavel(usuarioLogado);
        entidadeAuditada.setDataModificacao(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime());
    }

    private Usuario capturarUsuarioLogado() {
        return Optional.ofNullable((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .map(usernameUsuarioLogado -> usuarioRepository.findByUsername(usernameUsuarioLogado))
                .orElse(null);

    }
}
