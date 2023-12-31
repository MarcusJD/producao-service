CREATE TABLE TB_PRODUTO
(
    CODIGO BIGINT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    DESCRICAO VARCHAR(200),
    TAMANHO VARCHAR(100) NOT NULL,
    COR VARCHAR(100) NOT NULL,
    IMAGEM BLOB,
    PRIMARY KEY (CODIGO)
);

CREATE TABLE TB_STATUS
(
    ID BIGINT NOT NULL,
    DESCRICAO VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE TB_UNIDADE_MEDIDA
(
    ID BIGINT NOT NULL,
    DESCRICAO VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE TB_MATERIA_PRIMA
(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    ID_UNIDADE_MEDIDA BIGINT NOT NULL,
    NOME VARCHAR(100) NOT NULL,
    QTD_ATUAL BIGINT NOT NULL,
    CODIGO_LOTE_ATUAL VARCHAR(10),
    IMAGEM BLOB,
    PRIMARY KEY (ID),
    CONSTRAINT FK_UNIDADE_MEDIDA_MAT_PRIMA FOREIGN KEY (ID_UNIDADE_MEDIDA) REFERENCES TB_UNIDADE_MEDIDA(ID)
);

CREATE TABLE TB_PEDIDO_PRODUCAO
(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    COD_PRODUTO BIGINT NOT NULL,
    ID_STATUS BIGINT NOT NULL,
    QTD_SOLICITADA BIGINT NOT NULL,
    DATA_PEDIDO DATE NOT NULL,
    DATA_ENTREGA DATE,
    PRIMARY KEY (ID),
    CONSTRAINT FK_PRODUTO_PEDIDO_PRODUCAO FOREIGN KEY (COD_PRODUTO) REFERENCES TB_PRODUTO(CODIGO),
    CONSTRAINT FK_STATUS_PEDIDO_PRODUCAO  FOREIGN KEY (ID_STATUS) REFERENCES TB_STATUS(ID)
);