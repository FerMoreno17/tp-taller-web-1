package ar.edu.unlam.tallerweb1.modelo;

public class Texto {
	private Integer id;
	private Integer opcion;
	private String txt;
	private String resultado;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOpcion() {
		return opcion;
	}
	public void setOpcion(Integer opcion) {
		this.opcion = opcion;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	/*public String cambiarTextoIngresado(Integer opcion,String cadena) {
		switch(opcion) {
		case 1: this.resultado=cadena.toUpperCase();
		break;
		case 2: this.resultado = cadena.toLowerCase();
		break;
		case 3: for (int x=cadena.length()-1;x>=0;x--)this.resultado = this.resultado + cadena.charAt(x);
		break;
		case 4: this.resultado = Integer.toString(cadena.length());
		break;
		default:this.resultado = "error";
		}
		return this.resultado;
	}*/
	
	public String cambiarTextoIngresado() {
		switch(this.opcion) {
		case 1: this.resultado=this.txt.toUpperCase();
		break;
		case 2: this.resultado = this.txt.toLowerCase();
		break;
		case 3: for (int x=this.txt.length()-1;x>=0;x--)this.resultado = this.resultado + this.txt.charAt(x);
		break;
		case 4: this.resultado = Integer.toString(this.txt.length());
		break;
		default:this.resultado = "error";
		}
		return this.resultado;
	}
	
}
