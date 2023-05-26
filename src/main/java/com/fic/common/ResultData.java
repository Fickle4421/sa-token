package com.fic.common;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fickle
 * @create 2023-05-25 17:59
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData<T> extends ResultApi implements Serializable {

    private static final long serialVersionUID = 1111111221111111L;

    @Builder
    public ResultData(Integer code, String message, Boolean flag , T data){
        super(code,message,flag, DateUtil.format(new Date(),DatePattern.NORM_DATETIME_MS_PATTERN));
        this.data = data;
    }

    private T data;

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(ResultStatus.SUCCESS.getCode(), ResultStatus.SUCCESS.getMessage(), true, data);
    }
    public static <T> ResultData<T> error(T data) {
        return new ResultData<>(ResultStatus.ERROR.getCode(), ResultStatus.ERROR.getMessage(), true, data);
    }



}

