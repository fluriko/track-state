package sol.in.soul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sol.in.soul.dao.WebResourceShortRepository;
import sol.in.soul.model.WebResourceShort;
import java.util.List;
import java.util.Optional;

@Service
public class WebResourceShortServiceImpl implements WebResourceShortService {

    @Autowired
    private WebResourceShortRepository webResourceShortRepository;

    @Override
    public Optional<List<WebResourceShort>> getAll() {
        return Optional.of(webResourceShortRepository.findAll());
    }
}
