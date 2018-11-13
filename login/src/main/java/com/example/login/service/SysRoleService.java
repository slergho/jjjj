package com.example.login.service;


import com.example.login.domain.Result;
import com.example.login.domain.SysRole;
import com.example.login.dto.RoleDto;

import java.util.List;

public interface SysRoleService extends MerryyouBaseService<SysRole>{

    List<RoleDto> findAlls();

    Result saveRole(String data);

    RoleDto findRole(String id);

    Result<String> delRoles(String ids);

}
