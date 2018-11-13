package com.example.login.service.impl;

import com.example.login.domain.SysMenu;
import com.example.login.dto.MenuDto;
import com.example.login.repository.SysMenuRepository;
import com.example.login.repository.SysUserRepository;
import com.example.login.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository repository;

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public List<MenuDto> getMenus(String username, int menuType) {
        Set<SysMenu> menuSet = new HashSet<>();
        userRepository.findByUsername(username).getRoles()
                .forEach(e -> menuSet.addAll(e.getMenus()));

        List<MenuDto> menuDtoList = menuSet.stream()
                .filter(e -> e.getMenuType() == menuType)
                .map(e -> new MenuDto(e.getId(), e.getPId(), e.getName(), e.getUrl())).distinct()
                .collect(Collectors.toList());

        return menuDtoList;
    }

    @Override
    public List<MenuDto> getMenusList() {
        return repository.findAll().stream()
                .map(e ->new MenuDto(e.getId(), e.getPId(), e.getName(), e.getUrl()))
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getUrlByname(String username) {
        Set<SysMenu> mesnus = new HashSet<>();
        userRepository.findByUsername(username)
                .getRoles()
                .forEach(e->mesnus.addAll(e.getMenus()));
        return mesnus.stream().map(e->e.getUrl()).collect(Collectors.toSet());
    }

    @Override
    public String getPermissions(String username) {
        Set<SysMenu> mesnus = new HashSet<>();
        userRepository.findByUsername(username).getRoles()
                .forEach(e -> mesnus.addAll(e.getMenus()));

        return mesnus.stream()
                .map(e->e.getPermission())
                .collect(Collectors.joining(","));
    }
}
