package com.ldb.loanapi.Exceptions.ExceptionStatus;

import com.ldb.loanapi.Exceptions.DetailMessage.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends RuntimeException {
    private ErrorInfo errorInfo;

    public UnAuthorizedException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfo getError() {
        return errorInfo;
    }
}
