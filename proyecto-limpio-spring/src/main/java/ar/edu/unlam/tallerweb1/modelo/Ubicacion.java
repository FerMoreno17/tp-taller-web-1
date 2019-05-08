package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Ubicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer latitud;
	private Integer longitud;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLatitud() {
		return latitud;
	}
	public void setLatitud(Integer latitud) {
		this.latitud = latitud;
	}
	public Integer getLongitud() {
		return longitud;
	}
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	
	
}
