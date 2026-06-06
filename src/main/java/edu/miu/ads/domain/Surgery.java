package edu.miu.ads.domain;

public class Surgery {
    private int surgeryId;
    private String name;
    private String telephoneNumber;
    private Address address;

    public Surgery() {
    }

    public Surgery(int surgeryId, String name, String telephoneNumber, Address address) {
        this.surgeryId = surgeryId;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public int getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(int surgeryId) {
        this.surgeryId = surgeryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
