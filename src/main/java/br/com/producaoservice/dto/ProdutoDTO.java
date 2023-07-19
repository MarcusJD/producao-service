package br.com.producaoservice.dto;

import br.com.producaoservice.mappers.ProdutoMapper;
import br.com.producaoservice.model.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoDTO {

    private Long codigo;
    private String nome;
    private String descricao;
    private String tamanho;
    private String cor;
    private byte[] imagem;

}