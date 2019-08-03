package sol.in.soul.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sol.in.soul.model.WebResource;
import sol.in.soul.model.WebResourceShort;
import sol.in.soul.service.WebResourceService;
import sol.in.soul.service.WebResourceShortService;
import java.net.URI;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

@Component
public class WebResourceStatusCheck {

    @Autowired
    private WebResourceService webResourceService;

    @Autowired
    private WebResourceShortService webResourceShortService;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void createWebResourcesWithStatusesAndDurations() {
        List<WebResourceShort> webResourceShorts = webResourceShortService.getAll().orElseGet(Collections::emptyList);
        webResourceShorts.stream()
                .map(WebResource::of)
                .peek(this::setStatusAndDuration)
                .forEach(w -> webResourceService.save(w));
    }

    private void setStatusAndDuration(WebResource webResource) {
        long start = System.nanoTime();
        ResponseEntity re = restTemplate.exchange(URI.create(webResource.getResourceUrl()), HttpMethod.GET, null, String.class);
        long end = System.nanoTime();
        webResource.setResourceStatus(re.getStatusCode().toString());
        webResource.setResponseDuration(Duration.ofMillis(end - start));
    }
}
