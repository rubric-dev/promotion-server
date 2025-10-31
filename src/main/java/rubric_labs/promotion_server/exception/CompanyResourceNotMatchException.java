package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class CompanyResourceNotMatchException extends BizBaseException {
    public CompanyResourceNotMatchException() {
        super(ErrorCode.COMPANY_RESOURCE_NOT_MATCH);
    }
}
