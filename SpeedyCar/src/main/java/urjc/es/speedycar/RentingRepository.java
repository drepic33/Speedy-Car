package urjc.es.speedycar;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames="speedycar")
public interface RentingRepository extends JpaRepository<Renting, Integer> {
	@SuppressWarnings("unchecked")
	
	@CacheEvict(allEntries=true)	
	Renting save(Renting renting);	
	@Cacheable
	Renting findRentingsByKilometrosOrderByKilometrosDesc(int kilometros);
	@Cacheable
	List<Renting> findByMesesContratados(int mesesContratados);
}