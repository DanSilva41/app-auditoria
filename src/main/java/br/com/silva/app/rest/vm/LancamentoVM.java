package br.com.silva.app.rest.vm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LancamentoVM {

    private Long idAlbum;
    private Long idProdutor;
    private Long idMusica;
}
