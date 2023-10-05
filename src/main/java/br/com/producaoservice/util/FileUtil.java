package br.com.producaoservice.util;

import org.springframework.web.multipart.MultipartFile;

import br.com.producaoservice.exceptions.BadRequestException;

public class FileUtil {

    private static final long MAX_IMAGE_SIZE_BYTES = 5 * 1024 * 1024; // 5 MB in bytes

    public static boolean isImageSizeValid(MultipartFile file) {
        return file.getSize() <= MAX_IMAGE_SIZE_BYTES;
    }
    
    public static void validateImage(MultipartFile imagem) {
        if (!imagem.getContentType().startsWith("image/")) {
            throw new BadRequestException("O arquivo enviado não é uma imagem.");
        }
        if(!FileUtil.isImageSizeValid(imagem)) {
            throw new BadRequestException("A imagem deve possuir no máximo 5MB.");
        }
    }
}
