package urjc.es.speedycar;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames="speedycar")
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {
	@SuppressWarnings("unchecked")
		
		//liberamos la cache.
		@CacheEvict(allEntries=true)	
		Alquiler save(Alquiler alquiler);
		@Cacheable
		List <Alquiler> findByPrecio(int precio);
		@Cacheable
		List <Alquiler> findByInicioAlquiler(String inicioAlquiler);
	}
