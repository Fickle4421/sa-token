package com.fic.common;

import lombok.*;

import java.io.Serializable;

/**
 * @author fickle
 * @create 2023-05-25 17:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ResultData<T> extends ResultApi implements Serializable {

    private static final long serialVersionUID = 1111111221111111L;

    private T data;

}

