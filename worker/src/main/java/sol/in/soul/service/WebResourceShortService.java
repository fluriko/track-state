package sol.in.soul.service;

import sol.in.soul.model.WebResourceShort;
import java.util.List;
import java.util.Optional;

public interface WebResourceShortService {

    Optional<List<WebResourceShort>> getAll();

}
