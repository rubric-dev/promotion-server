package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class InvalidValueException extends BizBaseException {

    public InvalidValueException() {
        super(ErrorCode.INVALID_VALUE);
    }

    public InvalidValueException(String msg) {
        super(
                ErrorCode.INVALID_VALUE.getStatus(),
                ErrorCode.INVALID_VALUE.getCode(),
                msg
        );
    }

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
