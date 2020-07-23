package com.kaamkaaj.kaamkaaj.Models;

public class ServiceCategory {
    private String serviceId;
    private String serviceName;
    private String serviceImage;

    public ServiceCategory(String serviceId, String serviceName, String serviceImage) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceImage = serviceImage;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceImage(String serviceImage) {
        this.serviceImage = serviceImage;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceImage() {
        return serviceImage;
    }
}
