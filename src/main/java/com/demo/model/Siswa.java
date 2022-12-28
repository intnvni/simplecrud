package com.demo.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "siswa")
public class Siswa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nis;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "tgl_lahir")
	private Date tglLahir;
	
	@Column(name = "tpt_lahir")
	private String tptLahir;
	
	@Column(name = "ibu")
	private String ibu;
	
	@Column(name = "ayah")
	private String ayah;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "nem")
	private Integer nem;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jenkel")
	private Reference jenkel;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kode_sekolah")
	private Sekolah sekolah;

	public Integer getNis() { return nis; }
	public void setNis(Integer nis) { this.nis = nis; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public Date getTglLahir() { return tglLahir; }
	public void setTglLahir(Date tglLahir) { this.tglLahir = tglLahir; }

	public String getTptLahir() { return tptLahir; }
	public void setTptLahir(String tptLahir) { this.tptLahir = tptLahir; }

	public String getIbu() { return ibu; }
	public void setIbu(String ibu) { this.ibu = ibu; }

	public String getAyah() { return ayah; }
	public void setAyah(String ayah) { this.ayah = ayah; }

	public String getAlamat() { return alamat; }
	public void setAlamat(String alamat) { this.alamat = alamat; }

	public Integer getNem() { return nem; }
	public void setNem(Integer nem) { this.nem = nem; }
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Reference getJenkel() { return jenkel; }
	@JsonProperty
	public void setJenkel(Reference jenkel) { this.jenkel = jenkel; }
	
	@JsonIgnore
	public Sekolah getSekolah() { return sekolah; }
	@JsonProperty
	public void setSekolah(Sekolah sekolah) { this.sekolah = sekolah; }
	
	@Override
	public int hashCode() {
		return Objects.hash(nis);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Siswa other = (Siswa) obj;
		return Objects.equals(nis, other.nis);
	}
	
	@Override
	public String toString() {
		return "Siswa [nis=" + nis + ", name=" + name + ", tglLahir=" + tglLahir + ", tptLahir=" + tptLahir + ", ibu="
				+ ibu + ", ayah=" + ayah + ", alamat=" + alamat + ", nem=" + nem + "]";
	}
	
	
}
