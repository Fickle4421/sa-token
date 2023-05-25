package com.fic.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fickle
 * @create 2023-05-24 16:41
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultApi implements Serializable {

    private static final long serialVersionUID = 1111111222111111L;

    private Integer code;

    private String message;

    private Boolean flag;

}
