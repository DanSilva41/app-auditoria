package br.com.silva.app.rest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumDTO {

    private Integer id;
    private String titulo;
    private String autor;
}
