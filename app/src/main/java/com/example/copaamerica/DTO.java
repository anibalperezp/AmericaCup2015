package com.example.copaamerica;


public class DTO {
	private String partido;
	private boolean insertado;
	private int goles1; 
	private int goles2;

	public boolean isInsertado() {
		return insertado;
	}

	public void setInsertado(boolean insertado) {
		this.insertado = insertado;
	}
	
	public int getGoles2() {
		return goles2;
	}

	public void setGoles2(int goles2) {
		this.goles2 = goles2;
	}

	public int getGoles1() {
		return goles1;
	}

	public void setGoles1(int goles1) {
		this.goles1 = goles1;
	}
	
	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}


}
