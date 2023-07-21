package br.com.producaoservice.service;

import br.com.producaoservice.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;

public interface ProdutoService {

    public ResponseEntity<ProdutoDTO> createProduto(ProdutoDTO produtoDTO, MultipartFile imagem) throws IOException;

    public ResponseEntity<ProdutoDTO> updateProduto(ProdutoDTO produtoDTO, MultipartFile imagem) throws IOException;

    public ResponseEntity<Page<ProdutoDTO>> getProdutosPageable(Pageable pageable);

    public ResponseEntity<Void> deleteProdutoById(BigInteger id);


}
