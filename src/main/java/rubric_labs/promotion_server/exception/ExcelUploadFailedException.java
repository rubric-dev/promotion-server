package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class ExcelUploadFailedException extends BizBaseException {

    public ExcelUploadFailedException() {
        super(ErrorCode.EXCEL_FILE_UPLOAD_FAILED);
    }
}
