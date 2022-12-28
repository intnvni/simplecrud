package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.SekolahRepository;
import com.demo.dao.SiswaRepository;
import com.demo.model.Sekolah;
import com.demo.model.Siswa;

@Service
public class SekolahService implements ISekolah{
	@Autowired
	private SekolahRepository sekolahRepo;
	
	@Autowired
	private SiswaRepository siswaRepo;

	@Override
	public List<Sekolah> getSekolah() {
		return sekolahRepo.findAll();
	}
	@Override
	public Sekolah getSekolahByKode(Integer kodeSekolah) {
		return sekolahRepo.findById(kodeSekolah).get();
	}
	@Override
	public Sekolah saveSekolah(Sekolah sekolah) {
		return sekolahRepo.save(sekolah);
	}
	@Override
	@Transactional
	public int deleteSekolah(Sekolah sekolah) {
		sekolahRepo.delete(sekolah);
		return 1;
	}
	
	//========================= Siswa ==============================//
	@Override
	public List<Siswa> getSiswa() {
		return siswaRepo.findAll();
	}
	@Override
	public Siswa getSiswaByNis(Integer nis) {
		return siswaRepo.findById(nis).get();
	}
	@Override
	public Siswa saveSiswa(Siswa siswa) {
		return siswaRepo.save(siswa);
	}
	@Override
	@Transactional
	public int deleteSiswa(Siswa siswa) {
		return siswaRepo.deleteSiswa(siswa.getNis());
	}

}
