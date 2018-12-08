package by.pvt.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Address  {

    private long id;

    private String country;
    private String city;
    private String street;
    private Integer zip;
    private String houseNumber;
    private  int appartmentNumber;
    private String officeNumber;


    public Address(){

    }


    public Address(String country, String city, String houseNumber, int appartmentNumber) {
        this.country = country;
        this.city = city;
        this.houseNumber = houseNumber;
        this.appartmentNumber = appartmentNumber;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(int appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id: ",id)
                .append("appartmentNumber: ",appartmentNumber)
                .append("houseNumber: ",houseNumber)
                .append("city: ",city)
                .append("country: ",country)
                .append("zip", zip)
                .toString();
    }
}
