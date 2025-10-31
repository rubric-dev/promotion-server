package rubric_labs.promotion_server.exception;


import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class FileDeleteFailedException extends BizBaseException {

    public FileDeleteFailedException() {
        super(ErrorCode.FILE_DELETE_FAILED);
    }
}
