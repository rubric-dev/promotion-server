package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class DuplicateEmailException extends BizBaseException {
    public DuplicateEmailException() {
        super(ErrorCode.CONFLICT_EXIST_EMAIL);
    }
}
