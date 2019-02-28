package urjc.es.speedycar;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Renting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRenting;
	private int precio;
	private int mesesContratados;
	private int kilometros;
	private String matricula;
	
	@OneToMany(mappedBy="alquiler")
	private List <Vehiculo> vehiculos;
	
	public Renting(){}
	
	public Renting(int precio, int mesesContratados, int kilometros, String matricula) {
		
		this.precio = precio;
		this.mesesContratados = mesesContratados;
		this.kilometros = kilometros;
		this.matricula = matricula;
	}
	public int getIdRenting() {
		return idRenting;
	}
	public void setIdRenting(int idRenting) {
		this.idRenting = idRenting;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getMesesContratados() {
		return mesesContratados;
	}
	public void setMesesContratados(int mesesContratados) {
		this.mesesContratados = mesesContratados;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
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
		return "Renting [idRenting=" + idRenting + ", precio=" + precio + ", mesesContratados=" + mesesContratados
				+ ", kilometros=" + kilometros + ", matricula=" + matricula + "]";
	}
	
	
	
}
