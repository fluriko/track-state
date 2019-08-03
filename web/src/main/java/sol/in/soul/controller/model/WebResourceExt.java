package sol.in.soul.controller.model;

import sol.in.soul.model.WebResource;
import java.util.HashMap;
import java.util.Map;

public class WebResourceExt {

    private Long id;
    private String resourceName;
    private String resourceUrl;
    private String resourceStatus;
    private long responseDuration;
    private String color;
    private static Map<String, String> colorToStatus;

    static {
        colorToStatus = new HashMap<>();
        colorToStatus.put("2", "lightgreen");
        colorToStatus.put("3", "lightyellow");
        colorToStatus.put("4", "indianred");
        colorToStatus.put("5", "indianred");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public long getResponseDuration() {
        return responseDuration;
    }

    public void setResponseDuration(long responseDuration) {
        this.responseDuration = responseDuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static WebResourceExt of(WebResource webResource) {
        WebResourceExt result = new WebResourceExt();
        result.setId(webResource.getId());
        result.setResourceName(webResource.getResourceName());
        result.setResourceUrl(webResource.getResourceUrl());

        String resourceStatus = webResource.getResourceStatus();
        result.setResourceStatus(resourceStatus);
        result.setResponseDuration(webResource.getResponseDuration().toMillis());

        String color = colorToStatus.get(resourceStatus.subSequence(0,1));
        result.setColor(color);
        return result;
    }
}
