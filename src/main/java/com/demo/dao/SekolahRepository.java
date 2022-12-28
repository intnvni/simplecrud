package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.model.Sekolah;

public interface SekolahRepository extends JpaRepository<Sekolah, Integer>, JpaSpecificationExecutor<Sekolah>{

}
