package sol.in.soul.service;

import sol.in.soul.model.WebResource;
import java.util.List;
import java.util.Optional;

public interface WebResourceService {

    Optional<List<WebResource>> getAll();

    Optional<WebResource> create(WebResource webResource);

    void deleteById(Long id);
}
