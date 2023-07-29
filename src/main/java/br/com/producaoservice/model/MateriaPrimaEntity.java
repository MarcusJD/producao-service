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
@Table(name = "TB_MATERIA_PRIMA")
public class MateriaPrimaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_UNIDADE_MEDIDA", nullable = false)
    private UnidadeMedidaEntity unidadeMedida;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "QTD_ATUAL")
    private BigInteger qtdAtual;

    @Column(name = "CODIGO_LOTE_ATUAL")
    private String codigoLoteAtual;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "IMAGEM")
    private byte[] imagem;

}