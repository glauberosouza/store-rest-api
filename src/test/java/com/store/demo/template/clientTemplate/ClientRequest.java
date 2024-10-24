package com.store.demo.template.clientTemplate;


public class ClientRequest {
    private String name;
    private String email;
    private String addres;
    private String phone;

    public ClientRequest() {
    }

    public ClientRequest(String name, String email, String addres, String phone) {
        this.name = name;
        this.email = email;
        this.addres = addres;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}