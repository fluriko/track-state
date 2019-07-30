package sol.in.soul.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sol.in.soul.model.WebResource;

public interface WebResourceRepository extends JpaRepository<WebResource, Long> {
}
