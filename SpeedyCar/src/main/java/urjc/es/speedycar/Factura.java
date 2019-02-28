package urjc.es.speedycar;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombreFactura;
	private String tipo;
	private String nombreUsuario;
	private String matricula;
	private int precioAlquiler;
	private int precioRenting;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy="factura")
	private List <Vehiculo> vehiculos;
	
	public Factura(){}
	
	public Factura(String nombreFactura, String tipo, String nombreUsuario, String matricula, int precioAlquiler, int precioRenting) {
		
		this.nombreFactura = nombreFactura;
		this.tipo = tipo;
		this.nombreUsuario = nombreUsuario;
		this.matricula = matricula;
		this.precioAlquiler = precioAlquiler;
		this.precioRenting = precioRenting;
	}

	public void setId(int id) {
		this.id = id;
	}
	  
	public int getId() {
		return id;
	}

	public String getNombreFactura() {
		return nombreFactura;
	}

	public void setNombreFactura(String nombreFactura) {
		this.nombreFactura = nombreFactura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	public int getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public int getPrecioRenting() {
		return precioRenting;
	}

	public void setPrecioRenting(int precioRenting) {
		this.precioRenting = precioRenting;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", nombreFactura=" + nombreFactura + ", tipo=" + tipo + ", nombreUsuario="
				+ nombreUsuario + ", matricula=" + matricula + ", precioAlquiler=" + precioAlquiler + ", precioRenting="
				+ precioRenting + "]";
	}



}
