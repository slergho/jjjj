package com.example.login.repository;


import com.example.login.domain.SysMenu;

import java.util.List;

public interface SysMenuRepository extends MerryyouRepository<SysMenu> {

    List<SysMenu> findAllByOrderByOrderNumAsc();

    List<SysMenu> findAllByMenuType(Byte menuType);

}
