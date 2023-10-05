package br.com.producaoservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import br.com.producaoservice.dto.MateriaPrimaDTO;
import br.com.producaoservice.model.MateriaPrimaEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MateriaPrimaMapper extends MainMapper<MateriaPrimaEntity, MateriaPrimaDTO>{
	
	MateriaPrimaMapper INSTANCE = Mappers.getMapper(MateriaPrimaMapper.class);
	
    @Mapping(source = "unidadeMedida.id", target = "idUnidadeMedida")
    MateriaPrimaDTO entityToDto(MateriaPrimaEntity entity);
   
    @Mapping(source = "idUnidadeMedida", target = "unidadeMedida.id")
    MateriaPrimaEntity dtoToEntity(MateriaPrimaDTO entity);
}