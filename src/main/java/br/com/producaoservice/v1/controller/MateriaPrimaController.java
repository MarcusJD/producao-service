package br.com.producaoservice.v1.controller;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.producaoservice.dto.MateriaPrimaDTO;
import br.com.producaoservice.service.MateriaPrimaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/materias-primas")
public class MateriaPrimaController {
	
    private MateriaPrimaService materiaPrimaService;

    public MateriaPrimaController(MateriaPrimaService materiaPrimaService) {
        this.materiaPrimaService = materiaPrimaService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MateriaPrimaDTO> createMateriaPrima(
    		@RequestPart(value = "materiaPrima") @Valid MateriaPrimaDTO materiaPrimaDto,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem) throws IOException {
        return materiaPrimaService.createMateriaPrima(materiaPrimaDto, imagem);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MateriaPrimaDTO> updateMateriaPrima(
            @RequestPart(value = "materiaPrima") MateriaPrimaDTO materiaPrimaDto,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem) throws IOException {
        return materiaPrimaService.updateMateriaPrima(materiaPrimaDto, imagem);
    }

    @GetMapping("/{idMateriaPrima}")
    public ResponseEntity<MateriaPrimaDTO> getMateriaPrimaById(@PathVariable("idMateriaPrima") BigInteger idMateriaPrima) {
        return materiaPrimaService.getMateriaPrimaById(idMateriaPrima);
    }

    @GetMapping
    public ResponseEntity<Page<MateriaPrimaDTO>> getMateriasPrimasPageable(Pageable pageable) {
        return materiaPrimaService.getMateriasPrimasPageable(pageable);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMateriaPrimaById(BigInteger id) {
        return materiaPrimaService.deleteMateriaPrimaById(id);
    }
    
}
