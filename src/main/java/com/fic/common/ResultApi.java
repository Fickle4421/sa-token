package com.fic.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fickle
 * @create 2023-05-24 16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultApi implements Serializable {

    private static final long serialVersionUID = 1111111222111111L;

    public ResultApi(Integer code, String message, Boolean flag){
        this.code = code;
        this.message = message;
        this.flag = flag;
    }

    private Integer code;

    private String message;

    private Boolean flag;

    @Builder.Default
    private String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

}
