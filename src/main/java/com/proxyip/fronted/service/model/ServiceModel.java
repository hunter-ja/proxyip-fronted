package com.proxyip.fronted.service.model;

public class ServiceModel<T> {

    private boolean isSuccess = true;

    private T data;

    private String message;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceModel<T> error(String message) {
        ServiceModel<T> serviceModel = new ServiceModel<T>();
        serviceModel.setSuccess(false);
        serviceModel.setMessage(message);
        return serviceModel;
    }

    public ServiceModel<T>  success(T data, String message) {
        ServiceModel<T> serviceModel = new ServiceModel<T>();
        serviceModel.setSuccess(true);
        serviceModel.setData(data);
        serviceModel.setMessage(message);
        return serviceModel;
    }

    public ServiceModel<T>  success(T data) {
        return success(data, "");
    }
}
