package com.demo.service;

import java.util.List;

import com.demo.model.Sekolah;
import com.demo.model.Siswa;

public interface ISekolah {
	//==================== Sekolah =======================//
		public List<Sekolah> getSekolah();
		public Sekolah getSekolahByKode(Integer kodeSekolah);
		public Sekolah saveSekolah(Sekolah sekolah);
		public int deleteSekolah(Sekolah sekolah);
		
	//==================== Siswa =======================//
	public List<Siswa> getSiswa();
	public Siswa getSiswaByNis(Integer nis);
	public Siswa saveSiswa(Siswa siswa);
	public int deleteSiswa(Siswa siswa);
}
