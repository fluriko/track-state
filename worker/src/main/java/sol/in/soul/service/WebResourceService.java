package sol.in.soul.service;

import sol.in.soul.model.WebResource;
import java.util.Optional;

public interface WebResourceService {

    Optional<WebResource> save(WebResource webResource);
}
