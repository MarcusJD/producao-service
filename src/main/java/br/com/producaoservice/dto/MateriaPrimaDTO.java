package br.com.producaoservice.dto;

import java.math.BigInteger;

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
public class MateriaPrimaDTO {

    private BigInteger id;

    @NotNull(message = "Unidadee de medida é obrigatória")
    private BigInteger idUnidadeMedida;

    @Size(max = 100, message = "O tamnaho máximo do campo nome é de {max}")
    @NotNull(message = "Nome da matéria prima é obrigatória")
    private String nome;

    @NotNull(message = "Quantidade atual é obrigatória")
    private BigInteger qtdAtual;

    private String codigoLoteAtual;

    private byte[] imagem;
}