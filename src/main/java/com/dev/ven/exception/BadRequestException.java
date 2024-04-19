package com.dev.ven.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class BadRequestException extends RuntimeException {
    private Integer errCode;
    private String errMessage;
}
