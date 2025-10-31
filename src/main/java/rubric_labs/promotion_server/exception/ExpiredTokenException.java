package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class ExpiredTokenException extends BizBaseException {

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
