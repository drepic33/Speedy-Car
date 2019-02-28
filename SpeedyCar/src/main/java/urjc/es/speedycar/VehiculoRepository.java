package urjc.es.speedycar;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


	
	@CacheConfig(cacheNames="speedycar")
	public interface VehiculoRepository extends JpaRepository <Vehiculo, Integer>{
		@SuppressWarnings("unchecked")
		
		//liberamos la cache.
		@CacheEvict(allEntries=true)	
		Vehiculo save(Vehiculo vehiculo);
		@Cacheable
		Vehiculo findByModelo(String modelo);
		@Cacheable
		List<Vehiculo> findByPlazas(int plazas);
		@Cacheable
		List<Vehiculo> findByMarca(String marca);
		@Cacheable
		List<Vehiculo> findDistinctVehiculosByCombustibleOrderByCaballos(String combustible);
		@Cacheable
		List<Vehiculo> findDistinctVehiculosByCaballosOrderByCaballosDesc(int caballos);
		@Cacheable
		List<Vehiculo> findDistinctVehiculosByKilometrosByKilometrosDesc(int kilometros);
		@Cacheable
		Vehiculo findByMatricula(String matricula);
		
	}
	
	

