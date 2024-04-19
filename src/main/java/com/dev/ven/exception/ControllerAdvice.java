package com.dev.ven.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    //returning 404, i.e. the requested farmId could not be found
    @ExceptionHandler(FarmNotFoundException.class)
    public ResponseEntity<String> handleFarmNotFoundException(FarmNotFoundException farmNotFoundException) {
        return new ResponseEntity<String>(farmNotFoundException.getErrMessage(), HttpStatus.NOT_FOUND);
    }

    //returning 404, i.e. the requested crop could not be found on the server
    @ExceptionHandler(CropNotFoundException.class)
    public ResponseEntity<String> handleCropNotFoundException(CropNotFoundException cropNotFoundException) {
        return new ResponseEntity<String>(cropNotFoundException.getErrMessage(), HttpStatus.NOT_FOUND);
    }

    //returning 400, i.e. the required params like farmId or cropName are not passed
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException badRequestException) {
        return new ResponseEntity<String>(badRequestException.getErrMessage(), HttpStatus.BAD_REQUEST);
    }
}

