package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class InvalidApiKeyException extends BizBaseException {

    public InvalidApiKeyException() {
        super(ErrorCode.AUTH_INVALID_API_KEY);
    }
}
