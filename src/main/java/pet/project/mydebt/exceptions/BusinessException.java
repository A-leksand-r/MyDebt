package pet.project.mydebt.exceptions;

import lombok.Getter;
import pet.project.mydebt.exceptions.enums.Error;

@Getter
public class BusinessException extends Exception {
    private final Error errorCode;
    private final String details;

    public BusinessException(String message, Error errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.details = null;
    }

    public BusinessException(String message, Error errorCode, String details) {
        super(message);
        this.errorCode = errorCode;
        this.details = details;
    }
}
