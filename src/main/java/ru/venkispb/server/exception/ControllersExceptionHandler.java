package ru.venkispb.server.exception;

import com.google.common.base.Throwables;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiError exception(Exception exception, WebRequest request) {
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), Throwables.getRootCause(exception).getMessage());
    }

    @ExceptionHandler(value = NotFoundRuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiError notFoundException(Exception exception, WebRequest request) {
        return new ApiError(HttpStatus.NOT_FOUND.value(), Throwables.getRootCause(exception).getMessage());
    }

}

