package br.com.producaoservice.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UnidadeMedidaDTO {
	
    private BigInteger id;
    private String descricao;
    private String sigla;
}