package urjc.es.speedycar;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames="speedycar")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@SuppressWarnings("unchecked")
	
	@CacheEvict(allEntries=true)	
	Usuario save(Usuario usuario);	
	@Cacheable
	Usuario findByUserAndPassword(String user, String password);
	@Cacheable
	Usuario findByUser(String user);
}
