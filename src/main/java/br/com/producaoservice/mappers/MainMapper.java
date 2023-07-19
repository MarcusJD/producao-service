package br.com.producaoservice.mappers;

public interface MainMapper<E,D> {
    D entityToDto(E entity);
    E dtoToEntity(D dto);
}