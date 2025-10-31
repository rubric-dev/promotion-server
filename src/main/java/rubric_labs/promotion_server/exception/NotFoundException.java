package rubric_labs.promotion_server.exception;

import org.springframework.http.HttpStatus;
import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class NotFoundException extends BizBaseException {

    public NotFoundException(String msg) {
        super(msg, HttpStatus.NOT_FOUND);
    }

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND_RESOURCE);
    }

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
