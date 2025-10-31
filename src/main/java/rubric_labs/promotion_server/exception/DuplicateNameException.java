package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class DuplicateNameException extends BizBaseException {
    public DuplicateNameException() {
        super(ErrorCode.DUPLICATE_NAME);
    }
}
