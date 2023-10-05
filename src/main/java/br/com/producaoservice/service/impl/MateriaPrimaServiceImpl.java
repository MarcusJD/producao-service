package br.com.producaoservice.service.impl;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.producaoservice.dto.MateriaPrimaDTO;
import br.com.producaoservice.exceptions.NotFoundException;
import br.com.producaoservice.mappers.MateriaPrimaMapper;
import br.com.producaoservice.model.MateriaPrimaEntity;
import br.com.producaoservice.repository.MateriaPrimaRepository;
import br.com.producaoservice.service.MateriaPrimaService;
import br.com.producaoservice.util.FileUtil;

@Service
public class MateriaPrimaServiceImpl implements MateriaPrimaService {
	
    private MateriaPrimaRepository materiaPrimaRepository;
    
    public MateriaPrimaServiceImpl (MateriaPrimaRepository materiaPrimaRepository) {
        this.materiaPrimaRepository = materiaPrimaRepository;
    }

    @Override
    public ResponseEntity<MateriaPrimaDTO> createMateriaPrima(MateriaPrimaDTO materiaPrimaDTO, MultipartFile imagem) throws IOException {
        if(imagem != null) {
        	FileUtil.validateImage(imagem);
            materiaPrimaDTO.setImagem(imagem.getBytes());
        }
        MateriaPrimaEntity entity = MateriaPrimaMapper.INSTANCE.dtoToEntity(materiaPrimaDTO);
        MateriaPrimaEntity savedEntity = materiaPrimaRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(MateriaPrimaMapper.INSTANCE.entityToDto(savedEntity));
    }

    @Override
    public ResponseEntity<MateriaPrimaDTO> updateMateriaPrima(MateriaPrimaDTO materiaPrimaDTO, MultipartFile imagem) throws IOException {
        if(imagem != null) {
            FileUtil.validateImage(imagem);
            materiaPrimaDTO.setImagem(imagem.getBytes());
        }
        MateriaPrimaEntity entity = MateriaPrimaMapper.INSTANCE.dtoToEntity(materiaPrimaDTO);
        MateriaPrimaEntity updatedEntity = materiaPrimaRepository.save(entity);
        return ResponseEntity.ok(MateriaPrimaMapper.INSTANCE.entityToDto(updatedEntity));
    }

    @Override
    public ResponseEntity<MateriaPrimaDTO> getMateriaPrimaById(BigInteger idMateriaPrima) {
    	MateriaPrimaEntity entity = materiaPrimaRepository.findById(idMateriaPrima).orElseThrow(NotFoundException::new);
    	MateriaPrimaDTO dto = MateriaPrimaMapper.INSTANCE.entityToDto(entity);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<Page<MateriaPrimaDTO>> getMateriasPrimasPageable(Pageable pageable) {
        Page<MateriaPrimaEntity> page = materiaPrimaRepository.findAll(pageable);
        Page<MateriaPrimaDTO> materiaPrimaDTOPage = page.map(MateriaPrimaMapper.INSTANCE::entityToDto);
        return ResponseEntity.ok(materiaPrimaDTOPage);
    }

    @Override
    public ResponseEntity<Void> deleteMateriaPrimaById(BigInteger id) {
    	materiaPrimaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}