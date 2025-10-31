package rubric_labs.promotion_server.exception;

import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class AlreadyInvitedUserException extends BizBaseException {

    public AlreadyInvitedUserException() {
        super(ErrorCode.DUPLICATE_COMPANY_USER);
    }
}
