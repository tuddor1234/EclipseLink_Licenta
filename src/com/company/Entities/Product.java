package com.company.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Product")
public class Product extends Sellable  implements Serializable {

    private float shippingArea = -1;
    private String availability  = new String();


    public float getShippingArea() {
        return shippingArea;
    }

    public void setShippingArea(float shippingArea) {
        this.shippingArea = shippingArea;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


    public Product(){
        super();
    }


    public Product( String _name, String _desc , float _price, String _currency , float _shippingArea , String _availability){
        super(_name, _desc, _price, _currency );
        shippingArea = _shippingArea;
        availability = _availability;
    }


    public Product(Product product)
    {
        super(product);
        this.shippingArea = product.shippingArea;
        this.availability = product.availability;
    }


    @Override
    public String toString() {
        return "Product{" +
                "shippingArea=" + shippingArea +
                ", availability='" + availability + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}