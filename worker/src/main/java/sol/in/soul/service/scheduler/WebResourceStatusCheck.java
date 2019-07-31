package sol.in.soul.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sol.in.soul.model.WebResource;
import sol.in.soul.service.WebResourceService;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WebResourceStatusCheck {

    @Autowired
    private WebResourceService webResourceService;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void checkAndUpdateWebResourceStatus() {
        List<WebResource> webResources = webResourceService.getAll().orElseGet(Collections::emptyList);
        webResources.stream()
                .peek(w -> w.setResourceStatus(restTemplate
                        .exchange(URI.create(w.getResourceUrl()), HttpMethod.GET, null, String.class)
                        .toString().substring(1, 4)))
                .peek(w -> webResourceService.update(w))
                .collect(Collectors.toList());
    }
}
