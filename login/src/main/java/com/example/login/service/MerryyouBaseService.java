package com.example.login.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MerryyouBaseService<T> {

    T findOne(String id);

    T save(T t);

    List<T> findAll();

    Page<T> findAll(PageRequest pageRequest);

    void delete(String id);

}
