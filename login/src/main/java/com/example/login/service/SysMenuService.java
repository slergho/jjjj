package com.example.login.service;


import com.example.login.dto.MenuDto;

import java.util.List;
import java.util.Set;

public interface SysMenuService {
    List<MenuDto> getMenus(String username, int menuType);

    List<MenuDto> getMenusList();

    Set<String> getUrlByname(String username);

    String getPermissions(String username);

}
