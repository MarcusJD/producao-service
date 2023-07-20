package br.com.producaoservice.exceptions.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime dateTime;
    private String message;
    private String details;

}