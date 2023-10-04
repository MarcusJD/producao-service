package br.com.producaoservice.v1.controller;

import br.com.producaoservice.dto.ProdutoDTO;
import br.com.producaoservice.infra.mqueue.model.PedidoProducaoMQ;
import br.com.producaoservice.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProdutoDTO> createProduto(
    		@RequestPart(value = "produto") @Valid ProdutoDTO produtoDto,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem) throws IOException {
        return produtoService.createProduto(produtoDto, imagem);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProdutoDTO> updateProduto(
            @RequestPart(value = "produto") ProdutoDTO produtoDto,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem) throws IOException {
        return produtoService.updateProduto(produtoDto, imagem);
    }


    @GetMapping("/{codigoProduto}")
    public ResponseEntity<ProdutoDTO> getProdutoByCodigo(@PathVariable("codigoProduto") BigInteger codigoProduto) {
        return produtoService.getProdutoByCodigo(codigoProduto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> getProdutosPageable(Pageable pageable) {
        return produtoService.getProdutosPageable(pageable);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProdutoById(BigInteger id) {
        return produtoService.deleteProdutoById(id);
    }
    
    @PostMapping("/pedido-producao")
    public ResponseEntity<Void> createPedidoProducao(@RequestBody PedidoProducaoMQ pedidoProducao) {
        return produtoService.createPedidoProducao(pedidoProducao);
     }
}
