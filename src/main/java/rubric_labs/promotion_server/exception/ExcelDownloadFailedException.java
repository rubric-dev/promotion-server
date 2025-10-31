package rubric_labs.promotion_server.exception;

import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class ExcelDownloadFailedException extends BizBaseException {

    public ExcelDownloadFailedException() {
        super(ErrorCode.EXCEL_FILE_DOWNLOAD_FAILED);
    }
}
