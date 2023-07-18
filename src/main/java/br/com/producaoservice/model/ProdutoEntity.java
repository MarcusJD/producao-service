package br.com.producaoservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "TB_PRODUTO")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @NotNull
    @Size(max = 100)
    @Column(name = "NOME")
    private String nome;

    @Size(max = 200)
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull
    @Size(max = 100)
    @Column(name = "TAMANHO")
    private String tamanho;

    @NotNull
    @Size(max = 100)
    @Column(name = "COR")
    private String cor;

    @Lob
    @Column(name = "IMAGEM")
    private byte[] imagem;
}
