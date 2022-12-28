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

import com.demo.model.Sekolah;
import com.demo.service.SekolahService;

@RestController
@RequestMapping("/sekolah")
public class SekolahController {
	@Autowired
	private SekolahService sekolahService;
	
	@GetMapping("/fetchSekolah")
	public ResponseEntity<List<Sekolah>> fetchSekolah(){
		List<Sekolah> s = sekolahService.getSekolah();	
		return ResponseEntity.ok(s);
	}
	@GetMapping("/fetchSekolahByKode/{kodeSekolah}")
	public ResponseEntity<Sekolah> fetchByKodeDistrict(@PathVariable Integer kodeSekolah){
		Sekolah s = sekolahService.getSekolahByKode(kodeSekolah);	
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/saveSekolah")
	public Sekolah saveDistrict2 (@RequestBody Sekolah sekolah) {
		return sekolahService.saveSekolah(sekolah);
	}
	@PostMapping("/deleteSekolah")
	public ResponseEntity<Integer> deleteDistrict2 (@RequestBody Sekolah sekolah) {
		Integer s = sekolahService.deleteSekolah(sekolah);
		return ResponseEntity.ok(s);
	}
}
