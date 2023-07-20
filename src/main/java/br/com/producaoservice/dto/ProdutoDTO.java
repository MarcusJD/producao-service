package br.com.producaoservice.dto;

import br.com.producaoservice.mappers.ProdutoMapper;
import br.com.producaoservice.model.ProdutoEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Size(max = 100, message = "O tamnaho máximo do campo nome é de {max}")
    @NotNull(message = "Nome do produto é obrigatório")
    private String nome;

    @Size(max = 200, message = "O tamnaho máximo do campo descrição é de {max}")
    private String descricao;

    @Size(max = 100, message = "O tamnaho máximo do campo tamanho é de {max}")
    @NotNull(message = "Tamanho do produto é obrigatório")
    private String tamanho;

    @NotNull(message = "Cor do produto é obrigatório")
    private String cor;

    private byte[] imagem;

}