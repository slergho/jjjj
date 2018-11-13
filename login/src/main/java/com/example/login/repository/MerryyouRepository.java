package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MerryyouRepository<T> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {
}
