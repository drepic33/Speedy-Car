package urjc.es.speedycar;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Alquiler {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String inicioAlquiler;
	private String finAlquiler;
	private int precio;
	private String matricula;
	
	//Matricula
	@OneToMany(mappedBy="alquiler")
	private List <Vehiculo> vehiculos;
	
	public Alquiler(){}

	public Alquiler(String inicioAlquiler, String finAlquiler, int precio, String matricula) {
		
		this.inicioAlquiler = inicioAlquiler;
		this.finAlquiler = finAlquiler;
		this.precio = precio;
		this.matricula = matricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInicioAlquier() {
		return inicioAlquiler;
	}

	public void setInicioAlquier(String inicioAlquier) {
		this.inicioAlquiler = inicioAlquier;
	}

	public String getFinAlquiler() {
		return finAlquiler;
	}

	public void setFinAlquiler(String finAlquiler) {
		this.finAlquiler = finAlquiler;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public String toString() {
		return "Alquiler [id=" + id + ", inicioAlquiler=" + inicioAlquiler + ", finAlquiler=" + finAlquiler
				+ ", precio=" + precio + ", matricula=" + matricula + "]";
	}

	
}
