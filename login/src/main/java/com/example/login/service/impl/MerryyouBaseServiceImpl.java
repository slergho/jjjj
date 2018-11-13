package com.example.login.service.impl;

import com.example.login.repository.MerryyouRepository;
import com.example.login.service.MerryyouBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public abstract class MerryyouBaseServiceImpl<T> implements MerryyouBaseService<T> {

    @Autowired
    private MerryyouRepository<T> merryyouRepository;

    @Override
    public T findOne(String id) {
        return (T)merryyouRepository.findById(id).get();
    }

    @Override
    public T save(T t) {
        return (T)merryyouRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return merryyouRepository.findAll();
    }

    @Override
    public Page<T> findAll(PageRequest pageRequest) {
        return merryyouRepository.findAll(pageRequest);
    }

    @Override
    public void delete(String id) {
        merryyouRepository.deleteById(id);
    }
}
