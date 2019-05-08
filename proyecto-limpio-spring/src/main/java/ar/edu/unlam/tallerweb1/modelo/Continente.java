package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Continente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContinente;
	private String nombreContinente;
	
	public Integer getIdContinente() {
		return idContinente;
	}
	public void setIdContinente(Integer id) {
		this.idContinente = id;
	}
	public String getNombreContinente() {
		return nombreContinente;
	}
	public void setNombreContinente(String nombreContinente) {
		this.nombreContinente = nombreContinente;
	}
	
	
}
