package urjc.es.speedycar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String matricula;
	private String modelo;
	private String marca;
	private String combustible;
	private int plazas;
	private int caballos;
	
	
	@ManyToOne
	private Usuario usuario; 
	
	@ManyToOne
	private Factura factura;
	
	@ManyToOne
	private Alquiler alquiler;
	
	@ManyToOne
	private Renting renting;
	
	public Vehiculo(String matricula, String modelo, String marca, String combustible, int plazas, int caballos){
		
		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.combustible = combustible;
		this.plazas = plazas;
		this.caballos = caballos;
	}
	
	public void Vehiculo(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCombustible() {
		return combustible;
	}
	
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
	public int getPlazas() {
		return plazas;
	}
	
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	public int getCaballos() {
		return caballos;
	}
	
	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public Renting getRenting() {
		return renting;
	}

	public void setRenting(Renting renting) {
		this.renting = renting;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", combustible="
				+ combustible + ", plazas=" + plazas + ", caballos=" + caballos + "]";
	}
}
