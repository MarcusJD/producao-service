package br.com.producaoservice.service.impl;

import br.com.producaoservice.dto.ProdutoDTO;
import br.com.producaoservice.exceptions.BadRequestException;
import br.com.producaoservice.mappers.ProdutoMapper;
import br.com.producaoservice.model.ProdutoEntity;
import br.com.producaoservice.repository.ProdutoRepository;
import br.com.producaoservice.service.ProdutoService;
import br.com.producaoservice.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ResponseEntity<ProdutoDTO> createProduto(ProdutoDTO produtoDTO, MultipartFile imagem) throws IOException {
        if(imagem != null) {
            validateImage(imagem);
            produtoDTO.setImagem(imagem.getBytes());
        }
        ProdutoEntity entity = ProdutoMapper.INSTANCE.dtoToEntity(produtoDTO);
        ProdutoEntity savedEntity = produtoRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoMapper.INSTANCE.entityToDto(savedEntity));
    }

    @Override
    public ResponseEntity<ProdutoDTO> updateProduto(ProdutoDTO produtoDTO, MultipartFile imagem) throws IOException {
        if(imagem != null) {
            validateImage(imagem);
            produtoDTO.setImagem(imagem.getBytes());
        }
        if(produtoDTO.getCodigo() == null) {
            throw new BadRequestException("Código do produto não informado.");
        }
        ProdutoEntity entity = ProdutoMapper.INSTANCE.dtoToEntity(produtoDTO);
        ProdutoEntity updatedEntity = produtoRepository.save(entity);
        return ResponseEntity.ok(ProdutoMapper.INSTANCE.entityToDto(updatedEntity));
    }

    @Override
    public ResponseEntity<Page<ProdutoDTO>> getProdutosPageable(Pageable pageable) {
        Page<ProdutoEntity> page = produtoRepository.findAll(pageable);
        Page<ProdutoDTO> produtoDTOPage = page.map(ProdutoMapper.INSTANCE::entityToDto);
        return ResponseEntity.ok(produtoDTOPage);
    }

    @Override
    public ResponseEntity<Void> deleteProdutoById(BigInteger id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void validateImage(MultipartFile imagem) {
        if (!imagem.getContentType().startsWith("image/")) {
            throw new BadRequestException("O arquivo enviado não é uma imagem.");
        }
        if(!FileUtil.isImageSizeValid(imagem)) {
            throw new BadRequestException("A imagem deve possuir no máximo 5MB.");
        }
    }
}
