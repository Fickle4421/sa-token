package com.fic.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.fic.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fickle
 * @create 2023-05-24 10:38
 */
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 登陆
     */
    @RequestMapping("doLogin")
    public Map<String,Object> doLogin(@RequestBody User user){

        if (StrUtil.equals(user.getUsername(),"root") && StrUtil.equals(user.getPassword(),"4421")){
            StpUtil.login(user.getUserID());
            return new HashMap<>(){{
                put("result","登陆成功");
            }};
        }
        return new HashMap<>(){{
            put("result","登陆失败");
        }};
    }

    /**
     * 是否登陆
     */
    @RequestMapping("isLogin")
    public Map<String,Object> isLogin(){
        return new HashMap<>(){{
            put("isLogin",StpUtil.isLogin());

            if (StpUtil.isLogin())
                put("userID",StpUtil.getLoginId());
        }};
    }

    /**
     * 注销登陆
     */
    @RequestMapping("outLogin")
    public Map<String,Object> outLogin(){
        StpUtil.logout();
        return new HashMap<>(){{
            put("result","注销成功");
        }};
    }

    /**
     * 查看token信息
     */
    @RequestMapping("getTokenInfo")
    public Map<String,Object> getTokenInfo(){
        return new HashMap<>(){{
            put("result",StpUtil.getTokenInfo());
        }};
    }


    /**
     * 关于权限校验
     *  role角色相关 同理
     *
     *  这样就可以前端控制按钮
     *  <button v-if="arr.indexOf('user.delete') > -1"> 删除按钮 </button>
     */
    @RequestMapping("permissionValidation")
    public Map<String,Object> permissionValidation(){
        return new HashMap<>(){{
            put("result","success");
            put("当前账号所拥有的权限集合",StpUtil.getPermissionList());
            put("当前账号是否含有指定权限, 返回 true 或 false",StpUtil.hasPermission("user.add"));
            put("当前账号是否含有指定权限, 如果验证未通过，则抛出异常: NotPermissionException ","checkPermission  checkPermissionOr  checkPermissionAnd");
            StpUtil.checkPermission("start");
            put("当前账号是否含有指定角色","start");
        }};
    }



}