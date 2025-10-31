package rubric_labs.promotion_server.exception;

import rubric_labs.promotion_server.common.dto.response.ErrorCode;

public class FileNotFoundException extends BizBaseException {

    public FileNotFoundException() {
        super(ErrorCode.NOT_FOUND_RESOURCE);
    }
}
