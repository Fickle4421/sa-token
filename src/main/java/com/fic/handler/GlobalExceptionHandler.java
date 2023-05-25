package com.fic.handler;

import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常拦截
 * @author fickle
 * @create 2023-05-24 11:53
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //全局异常拦截
    @ExceptionHandler
    public Map<String,Object> handlerException(Exception e){
        e.getStackTrace();
        return new HashMap<>(){{
            put("result","fail");
            put("cause",e.getMessage());
        }};
    }

    //拦截权限
    @ExceptionHandler(NotPermissionException.class)
    public Map<String,Object> handlerPermissionException(NotPermissionException e){
        e.getStackTrace();
        return new HashMap<>(){{
            put("result","fail");
            put("cause",e.getMessage());
            put("loginType",e.getLoginType());
        }};
    }


    //拦截角色
    @ExceptionHandler(NotRoleException.class)
    public Map<String,Object> handlerRoleException(NotRoleException e){
        e.getStackTrace();
        return new HashMap<>(){{
            put("result","fail");
            put("cause",e.getMessage());
            put("loginType",e.getLoginType());
        }};
    }

}
