package br.com.producaoservice.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoContentException(String message){
        super(message);
    }
}
