package com.fic.bean;

import lombok.*;

/**
 * @author fickle
 * @create 2023-05-24 13:41
 */
@Data
@Builder
public class User {

    private String username;

    private String password;

    private Long userID;
}
