package tech.devinhouse.pharmacymanagement.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.devinhouse.pharmacymanagement.exception.BadRequestException;
import tech.devinhouse.pharmacymanagement.exception.NotFoundException;
import tech.devinhouse.pharmacymanagement.exception.ServerSideException;
import tech.devinhouse.pharmacymanagement.padroes.DefaultErrorResponse;


@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity tratarBadRequestException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        e.getCause()
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity tratarNotFoundException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        e.getMessage(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        e.getCause()
                ), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ServerSideException.class)
    public ResponseEntity tratarServerSideException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        e.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        e.getCause()
                ), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarMethodArgumentNotValidException(Exception e){
        return new ResponseEntity(
                new DefaultErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        e.getCause()
                ), HttpStatus.BAD_REQUEST
        );
    }

}
