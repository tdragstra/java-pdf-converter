package com.achmeaDemo.demoFulllStack.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Polis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	long id;
	int polisnr;
	float kosten;
	String verzekeraar;
	long klantid;
	
	public long id() {
		return id;
	}
	
	public int getPolisnr() {
		return polisnr;
	}
	public void setPolisnr(int polisnr) {
		this.polisnr = polisnr;
	}
	public float getKosten() {
		return kosten;
	}
	public void setKosten(float kosten) {
		this.kosten = kosten;
	}
	public String getVerzekeraar() {
		return verzekeraar;
	}
	public void setVerzekeraar(String verzekeraar) {
		this.verzekeraar = verzekeraar;
	}
	public long getKlantid() {
		return klantid;
	}
	public void setKlantid(long klantid) {
		this.klantid = klantid;
	}
	

}
