package br.com.producaoservice.util;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    private static final long MAX_IMAGE_SIZE_BYTES = 5 * 1024 * 1024; // 5 MB in bytes

    public static boolean isImageSizeValid(MultipartFile file) {
        return file.getSize() <= MAX_IMAGE_SIZE_BYTES;
    }
}
