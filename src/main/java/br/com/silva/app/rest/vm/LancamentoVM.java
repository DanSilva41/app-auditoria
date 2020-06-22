package br.com.silva.app.rest.vm;

import br.com.silva.app.rest.dto.AlbumDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LancamentoVM {

    private AlbumDTO album;
    private Long idProdutor;
    private List<Integer> musicas;
}
