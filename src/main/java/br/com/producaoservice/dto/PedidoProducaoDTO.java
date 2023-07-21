package br.com.producaoservice.dto;


import br.com.producaoservice.model.ProdutoEntity;
import br.com.producaoservice.model.StatusPedidoProducao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PedidoProducaoDTO {

    private Long id;

    private BigInteger produto;

    private BigInteger status;

    private BigInteger qtdSolicitada;

    private LocalDate dataPedido;

    private LocalDate dataEntrega;
}
