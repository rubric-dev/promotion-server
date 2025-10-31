package rubric_labs.promotion_server.common.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "0000", "서버 내부에서 오류가 발생하엿습니다."),

    AUTH_INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "0003", "잘못된 악세스 토큰입니다."),
    DATA_ACCESS_DENY(HttpStatus.FORBIDDEN, "0004", "접근이 불가능한 데이터 입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "0005", "이미 만료된 토큰입니다."),
    AUTH_INVALID_API_KEY(HttpStatus.UNAUTHORIZED, "0006", "잘못된 api key입니다"),
    COMPANY_RESOURCE_NOT_MATCH(HttpStatus.FORBIDDEN, "0007", "접근이 불가능한 데이터 입니다."),
    AUTH_EMAIL_NOT_REGISTERED(HttpStatus.UNAUTHORIZED, "0010", "등록되지 않은 이메일입니다"),
    AUTH_INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "0011", "잘못된 비밀번호입니다"),

    CONFLICT_EXIST_EMAIL(HttpStatus.CONFLICT, "2001", "이미 사용중인 이메일입니다"),
    CONFLICT_COACHING_DATA_EXIST(HttpStatus.CONFLICT, "2002", "해당 기간에 코칭 데이터가 존재하여 삭제할 수 없습니다."),
    CONFLICT_CROSS_EVALUATION_DATA_EXIST(HttpStatus.CONFLICT, "2003", "해당 기간에 크로스 평가 데이터가 존재하여 삭제할 수 없습니다."),
    CONFLICT_FINAL_EVALUATION_DATA_EXIST(HttpStatus.CONFLICT,  "2004","해당 기간에 최종 평가 데이터가 존재하여 삭제할 수 없습니다."),

    NOT_FOUND_RESOURCE(HttpStatus.NOT_FOUND, "3000", "대상을 찾을 수 없습니다"),
    NOT_FOUND_QUESTION(HttpStatus.NOT_FOUND, "3001", "질문을 찾을 수 없습니다"),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "3002", "사용자를 찾을 수 없습니다"),
    NOT_FOUND_GOAL(HttpStatus.NOT_FOUND, "3003", "목표를 찾을 수 없습니다"),
    NOT_FOUND_TOKEN(HttpStatus.NOT_FOUND, "3004", "토큰을 찾을 수 없습니다"),
    NOT_FOUND_DIAGNOSIS_USER(HttpStatus.NOT_FOUND, "3005", "진단 사용자를 찾을 수 없습니다"),
    NOT_FOUND_PERFORMANCE_SURVEY(HttpStatus.NOT_FOUND, "3006", "성과 조사를 찾을 수 없습니다"),
    NOT_FOUND_PERFORMANCE_SURVEY_USER(HttpStatus.NOT_FOUND, "3007", "성과 조사 사용자를 찾을 수 없습니다"),
    NOT_FOUND_AUTH(HttpStatus.NOT_FOUND, "3008", "인증 정보를 찾을 수 없습니다"),
    NOT_FOUND_COMPANY_USER(HttpStatus.NOT_FOUND, "3009", "회사에 속하지 않은 사용자입니다"),

    INVALID_VALUE(HttpStatus.BAD_REQUEST, "4001", "잘못된 입력입니다."),
    INVALID_PHONE_NUMBER(HttpStatus.BAD_REQUEST, "4002", "유효하지 않은 전화번호입니다."),
    INVALID_EMAIL_FORMAT(HttpStatus.BAD_REQUEST, "4003", "잘못된 이메일 형식입니다."),
    INVALID_DATE_INPUT(HttpStatus.BAD_REQUEST, "4004", "날짜를 입력해주세요."),
    INVALID_RESULT_OPEN_DATE(HttpStatus.BAD_REQUEST, "4005", "결과 공개일은 시작일 이후여야합니다."),
    INVALID_ANSWER(HttpStatus.BAD_REQUEST, "4006", "잘못된 답변입니다."),
    INVALID_COMPANY(HttpStatus.BAD_REQUEST, "4007", "잘못된 회사 정보입니다."),
    INVALID_AREA_KEY(HttpStatus.BAD_REQUEST, "4008", "잘못된 영역 키입니다."),
    INVALID_QUESTION_TYPE(HttpStatus.BAD_REQUEST, "4009", "지원하지 않는 질문 유형입니다."),

    FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "5001", "파일 업로드 중 오류가 발생했습니다"),
    FILE_DELETE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "5002", "파일 삭제 중 오류가 발생했습니다"),
    EXCEL_FILE_DOWNLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "5003", "엑셀 파일 다운로드 중 오류가 발생했습니다"),
    EXCEL_FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "5004", "엑셀 파일 업로드 중 오류가 발생했습니다"),

    DUPLICATE_COMPANY_USER(HttpStatus.BAD_REQUEST, "6001", "이미 등록된 유저 계정입니다"),
    DUPLICATE_NAME(HttpStatus.CONFLICT, "6006", "이미 사용중인 이름입니다"),
    DUPLICATE_REQUEST(HttpStatus.CONFLICT, "6007", "중복 요청이 존재합니다."),
    DUPLICATE_EVALUATION(HttpStatus.CONFLICT, "6008", "이미 평가한 유저입니다."),
    DUPLICATE_SURVEY_DATA(HttpStatus.CONFLICT, "6009", "이미 조사 데이터가 존재합니다."),
    REQUIRED_SUBSCRIPTION(HttpStatus.CONFLICT, "6010", "구독이 필요한 기능입니다."),

    INVALID_EXCEL_VALUE(HttpStatus.BAD_REQUEST, "7001", "잘못된 엑셀 값입니다. 확인 후 다시 요청해주세요"),
    EMPTY_VALUE_EXISTS(HttpStatus.BAD_REQUEST, "7002", "빈 값이 존재합니다."),

    COACHING_MENTEE_MODIFY_COACH_FIELDS(HttpStatus.BAD_REQUEST, "8001", "멘티는 코치의 필드를 수정할 수 없습니다."),
    COACHING_COACH_MODIFY_MENTEE_FIELDS(HttpStatus.BAD_REQUEST, "8002", "코치는 멘티의 필드를 수정할 수 없습니다."),
    COACHING_REQUIRED_ID(HttpStatus.BAD_REQUEST, "8003", "coachId 또는 coacheeId 중 하나는 필수입니다."),
    COACHING_GOAL_NOT_APPROVED(HttpStatus.BAD_REQUEST, "8004", "승인된 목표에만 코칭이 가능합니다."),

    // Diagnosis (진단) 관련 에러
    DIAGNOSIS_ALREADY_ANSWERED(HttpStatus.BAD_REQUEST, "9001", "이미 답변을 완료했습니다."),
    DIAGNOSIS_ALREADY_TERMINATED(HttpStatus.BAD_REQUEST, "9002", "이미 종료된 진단입니다."),
    DIAGNOSIS_TEMPLATE_NOT_SUBMITTED(HttpStatus.BAD_REQUEST, "9003", "제출되지 않은 템플릿입니다."),
    DIAGNOSIS_MISSING_REQUIRED_ANSWERS(HttpStatus.BAD_REQUEST, "9004", "필수 답변이 누락되었습니다."),
    DIAGNOSIS_MISSING_REQUIRED_STEPS(HttpStatus.BAD_REQUEST, "9005", "필수 단계가 누락되었습니다."),
    DIAGNOSIS_CANNOT_ADD_LIKERT_TO_INFO_AREA(HttpStatus.BAD_REQUEST, "9006", "정보영역에는 리커트 질문을 추가할 수 없습니다."),
    DIAGNOSIS_AREA_KEY_REQUIRED(HttpStatus.BAD_REQUEST, "9007", "영역 키는 필수입니다."),
    DIAGNOSIS_DATA_ALREADY_EXISTS(HttpStatus.CONFLICT, "9008", "이미 진단 데이터가 존재합니다."),

    // Evaluation (평가) 관련 에러
    EVALUATION_ALREADY_SUBMITTED(HttpStatus.BAD_REQUEST, "10001", "이미 평가를 제출했습니다."),
    EVALUATION_SCORE_LIMIT_EXCEEDED(HttpStatus.BAD_REQUEST, "10002", "총점은 100점 이하여야 합니다."),
    EVALUATION_DATA_EXISTS(HttpStatus.CONFLICT, "10003", "평가 데이터가 존재합니다."),
    EVALUATION_NOT_AUTHORIZED_TO_ANSWER(HttpStatus.FORBIDDEN, "10004", "답변 권한이 없습니다."),
    EVALUATION_NOT_AUTHORIZED_TO_VIEW(HttpStatus.FORBIDDEN, "10005", "조회 권한이 없습니다."),
    EVALUATION_TYPE_MISMATCH(HttpStatus.BAD_REQUEST, "10006", "평가 유형이 템플릿과 일치하지 않습니다."),
    EVALUATION_UNSUPPORTED_QUESTION_TYPE(HttpStatus.BAD_REQUEST, "10007", "지원하지 않는 질문 유형입니다."),
    EVALUATION_TEMPLATE_NOT_SUBMITTED(HttpStatus.BAD_REQUEST, "10008", "제출되지 않은 템플릿입니다."),

    // User (사용자) 관련 에러
    USER_NOT_FOUND_JOB(HttpStatus.BAD_REQUEST, "11001", "존재하지 않는 직무입니다."),
    USER_NOT_FOUND_RANK(HttpStatus.BAD_REQUEST, "11002", "존재하지 않는 직급입니다."),
    USER_NOT_FOUND_POSITION(HttpStatus.BAD_REQUEST, "11003", "존재하지 않는 직책입니다."),
    USER_NOT_FOUND_ROLE(HttpStatus.BAD_REQUEST, "11004", "존재하지 않는 역할입니다."),
    USER_INVALID_POSITION_NAME(HttpStatus.BAD_REQUEST, "11005", "잘못된 직책명입니다."),
    USER_INVALID_JOB_NAME(HttpStatus.BAD_REQUEST, "11006", "잘못된 직무명입니다."),
    USER_INVALID_RANK_NAME(HttpStatus.BAD_REQUEST, "11007", "잘못된 직급명입니다."),
    USER_INVALID_ROLE_NAME(HttpStatus.BAD_REQUEST, "11008", "잘못된 역할명입니다."),

    // Company (회사) 관련 에러
    COMPANY_OWNER_CANNOT_BE_DELETED(HttpStatus.BAD_REQUEST, "12001", "소유자는 삭제가 불가능합니다."),

    // Organization (조직) 관련 에러
    ORGANIZATION_CANNOT_SET_SELF_AS_PARENT(HttpStatus.BAD_REQUEST, "13001", "자기 자신을 부모로 설정할 수 없습니다."),
    ORGANIZATION_CIRCULAR_REFERENCE(HttpStatus.BAD_REQUEST, "13002", "하위 조직을 부모로 설정할 수 없습니다 (순환 참조)."),

    // Goal (목표) 관련 에러
    GOAL_NOT_LATEST_VERSION(HttpStatus.BAD_REQUEST, "14001", "최신 버전이 아닙니다."),
    GOAL_CANNOT_MODIFY_PENDING_APPROVAL(HttpStatus.BAD_REQUEST, "14002", "결재 대기중에는 수정 불가능합니다."),
    GOAL_ONLY_PENDING_CAN_BE_APPROVED(HttpStatus.BAD_REQUEST, "14003", "결재 대기중에만 결재 가능합니다."),
    GOAL_REJECT_REASON_REQUIRED(HttpStatus.BAD_REQUEST, "14004", "반려 사유는 필수입니다."),
    GOAL_KEYPOINT_ONLY_APPROVED(HttpStatus.BAD_REQUEST, "14005", "결재 되었을 때만 키포인트 작성 가능합니다."),
    GOAL_TEMP_DATA_EXISTS(HttpStatus.BAD_REQUEST, "14006", "임시 저장 데이터가 존재할 시 키포인트를 작성 할 수 없습니다."),
    GOAL_ALL_TASKS_NEED_KEYPOINT(HttpStatus.BAD_REQUEST, "14007", "모든 중점추진 과제에 키포인트를 추가해야합니다."),

    // Job Survey (업무조사) 관련 에러
    JOB_SURVEY_NOT_TARGET_USER(HttpStatus.BAD_REQUEST, "15001", "제출 대상자가 아닙니다."),
    JOB_SURVEY_ALREADY_SUBMITTED(HttpStatus.BAD_REQUEST, "15002", "이미 제출된 업무조사서입니다."),

    // Performance Survey (성과조사) 관련 에러
    PERFORMANCE_SURVEY_ALREADY_ANSWERED(HttpStatus.BAD_REQUEST, "16001", "이미 답변을 제출하셨습니다."),
    PERFORMANCE_SURVEY_MISSING_REQUIRED_ANSWERS(HttpStatus.BAD_REQUEST, "16002", "필수 답변이 누락되었습니다."),
    PERFORMANCE_SURVEY_MISSING_REQUIRED_STEPS(HttpStatus.BAD_REQUEST, "16003", "필수 단계가 누락되었습니다."),
    PERFORMANCE_SURVEY_CANNOT_ADD_LIKERT_TO_INFO_AREA(HttpStatus.BAD_REQUEST, "16004", "정보영역에는 리커트 질문을 추가할 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String msg;
}
