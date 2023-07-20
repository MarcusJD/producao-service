package br.com.producaoservice.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message){
        super(message);
    }
}
