package sol.in.soul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sol.in.soul.dao.WebResourceRepository;
import sol.in.soul.dao.WebResourceShortRepository;
import sol.in.soul.model.WebResource;
import java.util.List;
import java.util.Optional;

@Service
public class WebResourceServiceImpl implements WebResourceService {

    @Autowired
    private WebResourceRepository webResourceRepository;

    @Autowired
    private WebResourceShortRepository webResourceShortRepository;

    @Override
    public Optional<List<WebResource>> getAll() {
        return Optional.of(webResourceRepository.findAll());
    }

    @Override
    public Optional<WebResource> create(WebResource webResource) {
        return Optional.of(webResourceRepository.save(webResource));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(WebResource webResource) {
        webResourceRepository.deleteAllByResourceName(webResource.getResourceName());
        webResourceShortRepository.deleteAllByResourceName(webResource.getResourceName());
    }

    @Override
    public Optional<WebResource> getById(Long id) {
        return webResourceRepository.findById(id);
    }
}
