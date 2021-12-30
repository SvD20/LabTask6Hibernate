package edu.bsuir.labtask6.entities;

import javax.persistence.*;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "country")
    private String country;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "price")
    private int price;

    public Medication() {
    }

    public Medication(String title, String manufacturer, String country, String purpose, int price) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.country = country;
        this.purpose = purpose;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", country='" + country + '\'' +
                ", purpose='" + purpose + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
