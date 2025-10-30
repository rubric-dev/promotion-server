package rubric_labs.promotion_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cafe24RequestWrapper<T> {
    private T request;
}