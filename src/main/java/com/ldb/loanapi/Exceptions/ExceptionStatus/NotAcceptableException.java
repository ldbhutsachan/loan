package com.ldb.loanapi.Exceptions.ExceptionStatus;

import com.ldb.loanapi.Exceptions.DetailMessage.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException {

    private ErrorInfo errorInfo;

    public NotAcceptableException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public NotAcceptableException(String errorInfo) {
        super(errorInfo);
    }

    public ErrorInfo getError() {
        return errorInfo;
    }
}
