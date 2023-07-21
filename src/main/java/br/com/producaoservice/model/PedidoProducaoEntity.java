package br.com.producaoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "TB_PEDIDO_PRODUCAO")
public class PedidoProducaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO")
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS")
    private StatusPedidoProducao status;

    @Column(name = "QTD_SOLICITADA")
    private BigInteger qtdSolicitada;

    @Column(name = "DATA_PEDIDO")
    private LocalDate dataPedido;

    @Column(name = "DATA_ENTREGA")
    private LocalDate dataEntrega;

}