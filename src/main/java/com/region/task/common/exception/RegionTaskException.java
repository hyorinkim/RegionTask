package com.region.task.common.exception;

import com.region.task.common.Constants;
import org.springframework.http.HttpStatus;

import javax.swing.plaf.synth.Region;

public class RegionTaskException extends Exception {
    private static final long serialVersionUID = 4663380430591151694L;

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public RegionTaskException(Constants.ExceptionClass exceptionClass,HttpStatus httpStatus,String message){
        super(exceptionClass.toString()+message);
        this.exceptionClass=exceptionClass;
        this.httpStatus=httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass(){
        return exceptionClass;
    }

    public int getHttpStatusCode(){ return httpStatus.value();}

    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }
    public HttpStatus getHttpStatus(){return httpStatus;}
}

