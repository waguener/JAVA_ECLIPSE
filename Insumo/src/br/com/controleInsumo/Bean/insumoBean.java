package br.com.controleInsumo.Bean;

import java.util.Date;

public class insumoBean {

	
	int id,insumo;
	
	String tipo, impressora, modelo, status,data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInsumo() {
		return insumo;
	}
	public void setInsumo(int insumo) {
		this.insumo = insumo;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getImpressora() {
		return impressora;
	}
	public void setImpressora(String impressora) {
		this.impressora = impressora;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
