package br.com.producaoservice.infra.mqueue.model;

import java.math.BigInteger;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PedidoProducaoMQ {
	
    private BigInteger id;
    private BigInteger codigoProduto;
    private BigInteger status;
    private BigInteger qtdSolicitada;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;

}
