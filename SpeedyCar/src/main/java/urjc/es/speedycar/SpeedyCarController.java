package urjc.es.speedycar;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpeedyCarController {
	
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
	
	//User y Password Compartidas HttpSession
		String userCompartida;
		String passwordCompartida;
		
		@PostConstruct 
		//Indicamos los Vehiculos, Usuarios, Facturas, Alquileres y Rentings, añadidos por defecto al ejecutarse el programa.
		public void predeterminado(){
		
			/**
			//Creamos los Usuarios de SpeedyCar y los guardamos en sú respositorio.
			Usuario ruben = new Usuario("Ruben", "rubew", "1234");


			
			Usuario david = new Usuario("David", "dvd", "1234");
			
			
			Usuario miguel = new Usuario("Miguel", "mgl", "1234");
		
			
			Usuario carmen = new Usuario("Carmen", "crm", "1234");
		
			
			Usuario olivia = new Usuario("Olivia", "oli", "1234");
		
		
			Usuario daniel = new Usuario("Daniel", "dan", "1234");
			
			
			Usuario pedro = new Usuario("Pedro", "pdr", "1234");
			
			
			Usuario jose = new Usuario("Jose", "jse", "1234");
			
			
			Usuario sara = new Usuario("Sara", "sra", "1234");
			
		
			//Creamos los vehiculos.
			Vehiculo v1 = new Vehiculo("1010a", "Focus", "Ford", "Diesel", 5, 125);
			Vehiculo v2 = new Vehiculo("2020b", "Leon", "Seat", "Diesel", 5, 110);
			Vehiculo v3 = new Vehiculo("3030c", "Civic", "Honda", "Gasolina", 5, 150);
			Vehiculo v4 = new Vehiculo("4040d", "Passat", "VW", "Diesel", 5, 190);
			Vehiculo v5 = new Vehiculo("5050e", "TT", "Audi", "Gasolina", 4, 210);
			Vehiculo v6 = new Vehiculo("6060f", "Clio", "Renault", "Diesel", 5, 90);
			Vehiculo v7 = new Vehiculo("7070h", "Impreza", "Subapu", "Gasolina", 5, 180);
			Vehiculo v8 = new Vehiculo("8080i", "F40", "Ferrari", "Gasolina", 2, 350);

			v1.setUsuario(ruben);
			v2.setUsuario(david);
			v3.setUsuario(miguel);
			v4.setUsuario(carmen);
			v5.setUsuario(olivia);
			v6.setUsuario(daniel);
			v7.setUsuario(pedro);
			v8.setUsuario(sara);
			

			
			//Creamos los contratos Renting asociados a la matricula de un coche.
			Renting r1 = new Renting(10000, 24, 150000, "1010a");  
			Renting r2 = new Renting(35000, 60, 130000, "2020b");  
			Renting r3 = new Renting(20000, 48, 160000, "3030c");  
			Renting r4 = new Renting(25000, 48, 180000, "4040d");  
			
			v1.setRenting(r1);
			v2.setRenting(r2);
			v3.setRenting(r3);
			v4.setRenting(r4);
			
			rentingRepository.save(r1);
			rentingRepository.save(r2);
			rentingRepository.save(r3);
			rentingRepository.save(r4);

			//Creamos Facturas para el Renting
			Factura fr1 = new Factura("Samsung S.L", "Renting", "Daniel","6060f", 0, 10000);
			Factura fr2 = new Factura("Alcamapo S.L", "Renting", "Pedro","7070h", 0, 130000);
			
			fr1.setUsuario(ruben);
			fr2.setUsuario(david);
			
			v5.setFactura(fr1);
			v6.setFactura(fr1);
			
			facturaRepository.save(fr1); 
			facturaRepository.save(fr2); 
			

			
			//Creamos los contratos Alquiler asociados a la matricula de un coche.
			Alquiler a1 = new Alquiler("27/03/2019", "4/04/2019", 500, "3030c");	
			Alquiler a2 = new Alquiler("30/04/2019", "5/05/2019", 700, "4040d");
			Alquiler a3 = new Alquiler("30/04/2019", "5/05/2019", 2000, "8080i");
			
			v3.setAlquiler(a1);
			v4.setAlquiler(a2);
			v8.setAlquiler(a3);
			
			alquilerRepository.save(a1);
			alquilerRepository.save(a2);
			alquilerRepository.save(a3);
			
			
			//Creamos Facturas para el Alquiler
			Factura fa1 = new Factura("AMD", "Alquiler","Miguel" ,"3030c", 500, 0);
			Factura fa2 = new Factura("URJC", "Alquiler","Sara" ,"8080i", 20000, 0 );
			Factura fa3 = new Factura("Pegaplas", "Alquiler","Carmen" ,"4040d", 700, 0);
			
			fa1.setUsuario(ruben);
			fa2.setUsuario(olivia);
			fa3.setUsuario(miguel);
			
			v3.setFactura(fa1);
			v8.setFactura(fa2);
			v4.setFactura(fa3);

			facturaRepository.save(fa1);	
			facturaRepository.save(fa2);
			facturaRepository.save(fa3);
			
		
			vehiculoRepository.save(v1);
			vehiculoRepository.save(v2);
			vehiculoRepository.save(v3);
			vehiculoRepository.save(v4);
			vehiculoRepository.save(v5);
			vehiculoRepository.save(v6);
			vehiculoRepository.save(v7);
			vehiculoRepository.save(v8);
			
			usuarioRepository.save(ruben);
			usuarioRepository.save(david);
			usuarioRepository.save(miguel);
			usuarioRepository.save(carmen);
			usuarioRepository.save(olivia);
			usuarioRepository.save(daniel);
			usuarioRepository.save(pedro);
			usuarioRepository.save(sara);
			**/
			
		}
		
		//Indicamos la página principal de nuestra aplicación Web (SpeedyCar).
		@RequestMapping("/")
		public String principal (){
			return "index";
		}
		
		//Parte pública de nuestra aplicación Web donde se van a realizar las consultas.
		@RequestMapping("/realizarconsultas")
		public String realizarConsultas (){
			return "realizarconsultas";
		}
		
		//Parte privada de nuestra aplicación Web donde el usuario podrá loguearse y registrarse.
		@RequestMapping("/areaprivada")
		public String areaPrivada (){
			return "areaprivada";
		}
		
		//Login Usuario.
		@PostMapping("/login")
		public String loginUsuario(Model model, @RequestParam String user, @RequestParam String password, HttpSession sesion){
		
			//Comprobamos si existe o no un Usuario registrado con ese "user" y "password".
			Usuario usuario = usuarioRepository.findByUserAndPassword(user,password);
			
			//Si existe devuelve la información.		
			if (usuario!=null){
				sesion.setAttribute("user", user);
				sesion.setAttribute("password", password);
				userCompartida = user;
				passwordCompartida = password;
				
				return "loggincorrecto";
			}else{
				//Si no existe notifica el error al usuario.
				return "errorusuarionoexiste";
			}
		}

		//Área de gestión del usuario donde podra gestionar su equipo y consultar su información.
		@RequestMapping("/areagestionusuario")
		public String areaGestionUsuario (){
			return "areagestionusuario";
		}
		
		//Buscar Vehiculo.
		@GetMapping("/consultarmodelovehiculo/modelo")
		public String verVehiculo(Model model, @RequestParam String modelo){
			
			//Comprobamos si existe o no un Vehiculo registrado con ese "modelo".
			Vehiculo vehiculo = vehiculoRepository.findByModelo(modelo);

			//Si existe, mostramos la información.
			if (vehiculo!=null){	
				
				model.addAttribute("vehiculo", vehiculo);
				
				return "consultarmodelovehiculo";
			}else{
				//Si no existe notifica el error al usuario.
				return "errorvehiculonoexiste";
			}		
		}
		
		//Buscar Contratos Renting.
		@GetMapping("/consultarkilometrosrenting/kilometros")
		public String verRenting (Model model, @RequestParam int kilometros){
			
			//Comprobamos si existe o no el contrato Renting registrado con esos "Kilometros".
			Renting existe = rentingRepository.findRentingsByKilometrosOrderByKilometrosDesc(kilometros);		

			//Si existe, mostramos la información.
			if (existe!=null){
				Renting renting = rentingRepository.findRentingsByKilometrosOrderByKilometrosDesc(kilometros);
				
				model.addAttribute("Renting", renting);		
				
				return "consultarkilometrosrenting";
			}else{
				//Si no existe notifica el error al usuario.
				return "errorrentingnoexiste";
			}			
		}
		
		//Buscar Vehiculos por Plazas.
		@GetMapping("/consultarplazasvehiculo/plazas")
		public String verPlazasVehiculos (Model model, @RequestParam int plazas){
			
			//Comprobamos si existe o no un Vehiculo registrado con esas "plazas".
			List<Vehiculo> existe = vehiculoRepository.findByPlazas(plazas);

			//Si existe, mostramos la información.
			if (existe.isEmpty()){		
				
				return "errornoexistevehiculoplazas";
			}else{
				//Si no existe notifica el error al usuario.
				List<Vehiculo> vehiculo = vehiculoRepository.findByPlazas(plazas);
				
				model.addAttribute("vehiculo", vehiculo);		
				
				return "consultarplazasvehiculo";
			}		
		}	

		//Buscar Contratos de Alquiler.
		@GetMapping("/consultarprecioalquiler/precio")
		public String verNacionalidadJugadores (Model model, @RequestParam int precio){
			
			//Comprobamos si existe o no un Alquiler registrado con ese "precio".
			List<Alquiler> existe = alquilerRepository.findByPrecio(precio);

			//Si existe, mostramos la información.
			if (existe.isEmpty()){	
				
				return "errornoexistealquiler";
			}else{
				//Si no existe notifica el error al usuario.
				List<Alquiler> alquiler = alquilerRepository.findByPrecio(precio);
				
				model.addAttribute("alquiler", alquiler);		
				
				return "consultarprecioalquiler";
			}	
		}
		
		//Buscar por Vehiculos por combustible.
		@GetMapping("/consultarcombustiblevehiculo/combustible")
		public String verCombustible (Model model, @RequestParam String combustible){
			
			//Comprobamos si existe o no un Vehiculo registrado con ese "combustible".
			List <Vehiculo> existe = vehiculoRepository.findDistinctVehiculosByCombustibleOrderByCaballos(combustible);

			//Si existe, mostramos la información.
			if (existe!=null){
				List<Vehiculo> vehiculo = vehiculoRepository.findDistinctVehiculosByCombustibleOrderByCaballos(combustible);
				
				model.addAttribute("vehiculo", vehiculo);		
				
				return "consultarcombustiblevehiculo";
			}else{
				//Si no existe notifica el error al usuario.
				return "errorvehiculonoexiste";
			}	
		}	
		
		//Buscar Vehiculos por Potencia (caballos).
		@GetMapping("/consultarcaballosvehiculo/caballos")
		public String verTorneo (Model model, @RequestParam int caballos){
			
			//Comprobamos si existe o no un Vehiculo registrado con esos "caballos".
			List <Vehiculo> existe = vehiculoRepository.findDistinctVehiculosByCaballosOrderByCaballosDesc(caballos);

			//Si existe, mostramos la información.
			if (existe!=null){
				List<Vehiculo> vehiculo = vehiculoRepository.findDistinctVehiculosByCaballosOrderByCaballosDesc(caballos);
				
				model.addAttribute("vehiculo", vehiculo);		
				
				return "consultarcaballosvehiculo";
			}else{
				//Si no existe notifica el error al usuario.
				return "errorvehiculonoexiste";
			}	
		}
		
		//Registrar Usuario.
		@PostMapping("/usuario/nuevo")
		public String registroUsuario (@RequestParam String nombre, @RequestParam String user, @RequestParam String password){
			//Comprobamos si existe o no un Usuario registrado prevamente con ese "user" y "password".
			Usuario existe = usuarioRepository.findByUserAndPassword(user, password);
			
			//Si no existe lo crea (registra).
			if (existe==null){
				Usuario usuario = new Usuario(nombre, user, password);
				usuarioRepository.save(usuario);
				return "usuarioregistrado";
			}else{
				//Si existe notifica el error al usuario y no lo registra.
				return "errorregistro";
			}
		}

		//Información Usuario.
		@GetMapping("/informacionusuario/user/password")
		public String verUsuario(Model model, HttpSession sesion){
		
			//Cargamos los datos de la sesión del Usuario.
			String user = (String) sesion.getAttribute("user");
			String password = (String) sesion.getAttribute("password");

			model.addAttribute("user", user);
			model.addAttribute("password", user);
			
			model.addAttribute("userCompartida", userCompartida);
			model.addAttribute("passwordCompartida", passwordCompartida);
			
			Usuario usuario = usuarioRepository.findByUserAndPassword(user,password);
				
			model.addAttribute("usuario", usuario);
				
			return "consultardatosusuario";
		}
		
		//Inscribir Vehiculo.
		@GetMapping("/registrarvehiculo/user/password")
		public String registrarVehiculo(Model model, HttpSession sesion){
			
			//Cargamos los datos de la sesión del Usuario.
			String user = (String) sesion.getAttribute("user");
			String password = (String) sesion.getAttribute("password");

			model.addAttribute("user", user);
			model.addAttribute("password", user);
			
			model.addAttribute("userCompartida", userCompartida);
			model.addAttribute("passwordCompartida", passwordCompartida);
			
			Usuario usuario = usuarioRepository.findByUserAndPassword(user,password);
				
			model.addAttribute("usuario", usuario);
				
			return "registrarvehiculo";
		}
		
		//Registrar Vehiculo.
		@PostMapping("/vehiculo/nuevo")
		public String registroVehiculo (@RequestParam String matricula, @RequestParam String modelo, @RequestParam String marca, @RequestParam String combustible, @RequestParam int plazas ,@RequestParam int caballos ,HttpSession sesion){

			//Comprobamos si existe o no un Vehiculo registrado con esa "matricula".
			Vehiculo existe = vehiculoRepository.findByMatricula(matricula);		

			//Si no existe, continuamos con el registro del vehiculo.
			if (existe==null){
				Vehiculo vehiculo = new Vehiculo(matricula, modelo, marca, combustible, plazas, caballos);
				vehiculoRepository.save(vehiculo);
				
				return "vehiculoregistrado";
			}else{
				//Si existe notifica el error al usuario y no lo registra.
				return "errorregistrovehiculo";
			}
		}
		
		//Inscribir Factura.
		@GetMapping("/registrarfactura/user/password")
		public String registrarFactura(Model model, HttpSession sesion){
			
			//Cargamos los datos de la sesión del Usuario.
			String user = (String) sesion.getAttribute("user");
			String password = (String) sesion.getAttribute("password");

			model.addAttribute("user", user);
			model.addAttribute("password", user);
			
			model.addAttribute("userCompartida", userCompartida);
			model.addAttribute("passwordCompartida", passwordCompartida);
			
			Usuario usuario = usuarioRepository.findByUserAndPassword(user,password);
				
			model.addAttribute("usuario", usuario);
				
			return "registrarfactura";
		}
		
		//Registrar Factura.
		@PostMapping("/factura/nuevo")
		public String registroFactura (@RequestParam String nombreFactura, @RequestParam String tipo ,@RequestParam String nombreUsuario, @RequestParam String matricula, @RequestParam int precioAlquiler, @RequestParam int precioRenting, HttpSession sesion){
			
			//Comprobamos si existe o no una Factura registrada con ese "nombreFactura".
			Factura existe = facturaRepository.findByNombreFactura(nombreFactura);

			//Si no existe, continuamos con el registro de la factura.
			if (existe==null){
				Factura factura = new Factura(nombreFactura, tipo, nombreUsuario, matricula, precioAlquiler, precioRenting);
				facturaRepository.save(factura);
				
				return "facturaregistrada";
			}else{
				//Si existe notifica el error al usuario y no lo registra.
				return "errorregistrofactura";
			}
		}	
	}