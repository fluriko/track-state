package sol.in.soul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sol.in.soul.dao.WebResourceRepository;
import sol.in.soul.model.WebResource;
import java.util.Optional;

@Service
public class WebResourceServiceImpl implements WebResourceService {

    @Autowired
    private WebResourceRepository webResourceRepository;

    @Override
    public Optional<WebResource> save(WebResource webResource) {
        return Optional.of(webResourceRepository.save(webResource));
    }
}
