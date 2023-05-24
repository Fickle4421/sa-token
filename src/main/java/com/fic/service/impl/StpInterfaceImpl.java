package com.fic.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 自定义权限验证接口拓展
 *
 * @author fickle
 * @create 2023-05-24 11:34
 */
@Service
public class StpInterfaceImpl implements StpInterface {


    /**
     * 返回 账号所拥有的权限集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<>(){{
            add("user.add");
            add("user.update");
            add("fic.*");
        }};
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return new ArrayList<>(){{
            add("admin");
            add("super-admin");
        }};
    }
}
