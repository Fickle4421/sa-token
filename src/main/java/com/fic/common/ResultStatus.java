package com.fic.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author fickle
 * @create 2023-05-25 17:52
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultStatus {

    SUCCESS( 1001 , "执行成功"),
    ERROR( 1002 , "执行失败");

    private Integer code;

    private String message;

}
