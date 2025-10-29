package rubric_labs.promotion_server.common.dto.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class ExcelValidationError {
    private final int rowIndex;
    private final List<FieldError> fields;

    @Getter
    @RequiredArgsConstructor
    public static class FieldError {
        private final String name;
        private final FieldErrorCode code;
        private final String message;
        private final int colIndex;

        public static FieldError of(String name, int colIndex, FieldErrorCode code) {
            return new FieldError(name, code, name + code.getMessage(), colIndex);
        }
    }

    @Getter
    @AllArgsConstructor
    public enum FieldErrorCode{
        REQUIRED("은(는) 필수 값입니다."),
        INVALID_VALUE("이(가) 유효하지 않습니다.")
        ;

        String message;
    }
}
