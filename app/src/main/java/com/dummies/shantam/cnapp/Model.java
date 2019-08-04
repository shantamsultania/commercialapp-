package com.dummies.shantam.cnapp;

/**
 * Created by hp on 08-04-2019.
 */
public class Model {

    String title,image,description,address,dealer,facing,dealtype,size;


    public Model(String title, String image, String description, String address, String dealer, String facing, String dealtype, String size) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.address = address;
        this.dealer = dealer;
        this.facing = facing;
        this.dealtype = dealtype;
        this.size = size;
    }

    public Model() {
    }

    //getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public String getDealtype() {
        return dealtype;
    }

    public void setDealtype(String dealtype) {
        this.dealtype = dealtype;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

