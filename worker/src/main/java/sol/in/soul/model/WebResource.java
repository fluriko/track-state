package sol.in.soul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEB_RESOURCES")
public class WebResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESOURCE_ID")
    private Long id;

    @Column(name = "RESOURCE_NAME")
    private String resourceName;

    @Column(name = "RESOURCE_URL")
    private String resourceUrl;

    @Column(name = "RESOURCE_STATUS")
    private String resourceStatus;

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
}
