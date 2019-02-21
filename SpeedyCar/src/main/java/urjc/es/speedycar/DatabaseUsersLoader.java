package urjc.es.speedycar;

//import javax.annotation.PostConstpuct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {
	
	//Inyectamos los repositorios.
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private VehiculoRepository vehiculoRepository;	
	@Autowired
	private RentingRepository rentingRepository;	
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@PostConstpuct
	private void initDataBase(){
	
		//Creamos los Usuarios de SpeedyCar.
		Usuario ruben = new Usuario(1, "Ruben", "rubew", "1234", "ROLE_USER");
		usuarioRepository.save(ruben);

		Usuario david = new Usuario(2, "David", "dvd", "1234", "ROLE_USER");
		usuarioRepository.save(david);
	
	
		//Creamos los vehiculos.
		Vehiculo v1 = new Vehiculo("1010a", "Focus", "Ford", "Diesel", 5, 125);
		Vehiculo v2 = new Vehiculo("2020b", "Leon", "Seat", "Diesel", 5, 110);
		Vehiculo v3 = new Vehiculo("3030c", "Civic", "Honda", "Gasolina", 5, 150);
		Vehiculo v4 = new Vehiculo("4040d", "Passat", "VW", "Diesel", 5, 190);
		Vehiculo v5 = new Vehiculo("5050e", "TT", "Audi", "Gasolina", 4, 210);
		Vehiculo v6 = new Vehiculo("6060f", "Clio", "Renault", "Diesel", 5, 90);
		Vehiculo v7 = new Vehiculo("7070h", "Impreza", "Subapu", "Gasolina", 5, 180);
		Vehiculo v8 = new Vehiculo("8080i", "F40", "Ferrari", "Gasolina", 2, 350);

		
		vehiculoRepository.save(v1);
		vehiculoRepository.save(v2);
		vehiculoRepository.save(v3);
		vehiculoRepository.save(v4);
		vehiculoRepository.save(v5);
		vehiculoRepository.save(v6);
		vehiculoRepository.save(v7);
		vehiculoRepository.save(v8);
		
		//Creamos los contratos Renting asociados a la matricula de un coche.
		Renting r1 = new Renting(01, 250, 24, 150000, "1010a");  
		Renting r2 = new Renting(02, 200, 60, 130000, "2020b");  
		Renting r3 = new Renting(03, 300, 48, 160000, "3030c");  
		Renting r4 = new Renting(04, 350, 48, 180000, "4040d");  
		
		
		rentingRepository.save(r1);
		rentingRepository.save(r2);
		rentingRepository.save(r3);
		rentingRepository.save(r4);

		//Creamos Facturas para el Renting
		Factura fr1 = Factura(1, "Woxter SL", "Renting", 6000, 1, 1010a); 
		Factura fr2 = Factura(2, "BlueMasa SL", "Renting", 12000, 2, 2020b); 
		
		facturaRepository.save(fr1); 
		facturaRepository.save(fr2); 

		
		//Creamos los contratos Alquiler asociados a la matricula de un coche.
		Alquiler a1 = new Alquiler(1, "27/03/2019", "4/04/2019", 40, 3030c);	
		Alquiler a2 = new Alquiler(2, "30/04/2019", "5/05/2019", 110, 4040d);
		Alquiler a3 = new Alquiler(3, "30/04/2019", "5/05/2019", 300, 8080i);
		
		
		AlquilerRepository.save(a1);
		AlquilerRepository.save(a2);
		AlquilerRepository.save(a3);
		
		
		//Creamos Facturas para el Alquiler
		Factura fa1 = Factura(3, "Alcampo", "Alquiler", 360, 1, 3030c); 
		Factura fa2 = Factura(4, "URJC", "Alquiler", 1800, 2, 8080i);
		Factura fa3 = Factura(5, "Pegaplas", "Alquiler", 660, 2, 4040d);

		facturaRepository.save(fa1);	
		facturaRepository.save(fa2);
		facturaRepository.save(fa3);
	}
}