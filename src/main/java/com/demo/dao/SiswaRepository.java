package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Siswa;

public interface SiswaRepository extends JpaRepository<Siswa, Integer>, JpaSpecificationExecutor<Siswa>{
	@Modifying
	@Query(value = "delete from Siswa where nis = :nis")
	public int deleteSiswa(Integer nis);
}
