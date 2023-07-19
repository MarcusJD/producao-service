package br.com.producaoservice.mappers;

import br.com.producaoservice.dto.ProdutoDTO;
import br.com.producaoservice.model.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProdutoMapper extends MainMapper<ProdutoEntity, ProdutoDTO> {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);
}