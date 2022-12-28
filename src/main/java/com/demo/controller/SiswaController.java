package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Siswa;
import com.demo.service.SekolahService;

@RestController
@RequestMapping("/siswa")
public class SiswaController {
	@Autowired
	private SekolahService siswaService;
	
	@GetMapping("/fetchSiswa")
	public ResponseEntity<List<Siswa>> fetchSiswa(){
		List<Siswa> s = siswaService.getSiswa();	
		return ResponseEntity.ok(s);
	}
	@GetMapping("/fetchSiswaByNis/{nis}")
	public ResponseEntity<Siswa> fetchByNis(@PathVariable Integer nis){
		Siswa s = siswaService.getSiswaByNis(nis);	
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/saveSiswa")
	public Siswa saveDistrict2 (@RequestBody Siswa siswa) {
		return siswaService.saveSiswa(siswa);
	}
	@PostMapping("/deleteSiswa")
	public ResponseEntity<Integer> deleteDistrict2 (@RequestBody Siswa siswa) {
		Integer s = siswaService.deleteSiswa(siswa);
		return ResponseEntity.ok(s);
	}
}
