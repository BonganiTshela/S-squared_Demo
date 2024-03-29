package co.za.ssquared.cruddemo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "zip")
    private String zip;
    @Column(name = "country")
    private String country;

    public Address(){

    }

    public Address(String streetName, String cityName, String zip, String country) {
        this.streetName = streetName;
        this.cityName = cityName;
        this.zip = zip;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
