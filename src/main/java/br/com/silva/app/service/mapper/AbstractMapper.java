package br.com.silva.app.service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;

import java.util.List;

public interface AbstractMapper<T, D> {

    T paraEntidade(D dto);

    @InheritInverseConfiguration
    D paraDTO(T entity);

    @IterableMapping(qualifiedByName = "paraDTO")
    Iterable<D> paraIterableDTO(Iterable<T> entities);

    @IterableMapping(qualifiedByName = "paraDTO")
    List<D> paraListaDTO(List<T> entities);

    @IterableMapping(qualifiedByName = "paraEntidade")
    List<T> paraListaEntidade(List<D> dtos);

}
