package rubric_labs.promotion_server.exception;

import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class InvalidExcelValueException extends BizBaseException {

    public InvalidExcelValueException() {
        super(ErrorCode.INVALID_EXCEL_VALUE);
    }

    public InvalidExcelValueException(String msg) {
        super(ErrorCode.INVALID_EXCEL_VALUE.getStatus(), ErrorCode.INVALID_VALUE.getCode(), msg);
    }
}
