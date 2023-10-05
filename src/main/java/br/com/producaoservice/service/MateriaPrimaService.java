package br.com.producaoservice.service;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import br.com.producaoservice.dto.MateriaPrimaDTO;

public interface MateriaPrimaService {
	
    public ResponseEntity<MateriaPrimaDTO> createMateriaPrima(MateriaPrimaDTO materiaPrimaDTO, MultipartFile imagem) throws IOException;

    public ResponseEntity<MateriaPrimaDTO> updateMateriaPrima(MateriaPrimaDTO materiaPrimaDTO, MultipartFile imagem) throws IOException;

    public ResponseEntity<MateriaPrimaDTO> getMateriaPrimaById(BigInteger idMateriaPrima);

    public ResponseEntity<Page<MateriaPrimaDTO>> getMateriasPrimasPageable(Pageable pageable);

    public ResponseEntity<Void> deleteMateriaPrimaById(BigInteger id);

}
