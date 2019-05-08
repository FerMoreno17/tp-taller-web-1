package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String pais;
	private Boolean capital;
	@OneToOne
	private Ubicacion ubicacion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Boolean getCapital() {
		return capital;
	}
	public void setCapital(Boolean capital) {
		this.capital = capital;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
}
