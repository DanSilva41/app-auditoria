package br.com.silva.app.rest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MusicaDTO {

    private Integer id;
    private String titulo;
    private String letra;
}
