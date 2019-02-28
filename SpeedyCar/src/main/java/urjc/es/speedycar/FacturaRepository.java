package urjc.es.speedycar;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;



	@CacheConfig(cacheNames="speedycar")
	public interface FacturaRepository extends JpaRepository <Factura, Integer>{
		@SuppressWarnings("unchecked")
		
		@CacheEvict(allEntries=true)	
		Factura save(Factura factura);
		@Cacheable
		Factura findByNombreFactura(String nombreFactura);
	}
