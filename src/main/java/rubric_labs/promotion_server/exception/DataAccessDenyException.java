package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class DataAccessDenyException extends BizBaseException {
    public DataAccessDenyException() {
        super(ErrorCode.COMPANY_RESOURCE_NOT_MATCH);
    }
}
