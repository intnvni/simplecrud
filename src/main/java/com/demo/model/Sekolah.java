package com.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "sekolah")
public class Sekolah {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kodeSekolah;
	
	@Column(name = "name")
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "tgl_berdiri")
	private Date tglBerdiri;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "akreditas")
	private Reference akreditas;
	
	@Column(name = "jml_siswa")
	private Integer jmlSiswa;
	
	@Column(name = "total_pendapatan")
	private Integer totalPendapatan;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sekolah", orphanRemoval = true)
	private List<Siswa> siswas = new ArrayList<Siswa>();

	public Integer getKodeSekolah() { return kodeSekolah; }
	public void setKodeSekolah(Integer kodeSekolah) { this.kodeSekolah = kodeSekolah; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public Date getTglBerdiri() { return tglBerdiri; }
	public void setTglBerdiri(Date tglBerdiri) { this.tglBerdiri = tglBerdiri; }
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Reference getAkreditas() { return akreditas; }
	@JsonProperty
	public void setAkreditas(Reference akreditas) { this.akreditas = akreditas; }

	public Integer getJmlSiswa() { return jmlSiswa; }
	public void setJmlSiswa(Integer jmlSiswa) { this.jmlSiswa = jmlSiswa; }

	public Integer getTotalPendapatan() { return totalPendapatan; }
	public void setTotalPendapatan(Integer totalPendapatan) { this.totalPendapatan = totalPendapatan; }

	public List<Siswa> getSiswas() { return siswas; }
	public void setSiswas(List<Siswa> siswas) { this.siswas = siswas; }
	
	@Override
	public int hashCode() {
		return Objects.hash(kodeSekolah);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sekolah other = (Sekolah) obj;
		return Objects.equals(kodeSekolah, other.kodeSekolah);
	}
	
	@Override
	public String toString() {
		return "Sekolah [kodeSekolah=" + kodeSekolah + ", name=" + name + ", tglBerdiri=" + tglBerdiri + ", akreditas="
				+ akreditas + ", jmlSiswa=" + jmlSiswa + ", totalPendapatan=" + totalPendapatan + "]";
	}	
}
