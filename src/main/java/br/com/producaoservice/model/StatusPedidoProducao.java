package br.com.producaoservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "TB_STATUS_PEDIDO_PRODUCAO")
public class StatusPedidoProducao {

    @Id
    @Column(name = "ID")
    private BigInteger id;

    @NotNull
    @Size(max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;

}