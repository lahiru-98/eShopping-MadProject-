package com.example.eshopping.Model;

public class SellerOffers {

     private String des,endDate,offer,offerID,sterName;

    public SellerOffers() {
    }

    public SellerOffers(String des, String endDate, String offer, String offerID, String sterName) {
        this.des = des;
        this.endDate = endDate;
        this.offer = offer;
        this.offerID = offerID;
        this.sterName = sterName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getOfferID() {
        return offerID;
    }

    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    public String getSterName() {
        return sterName;
    }

    public void setSterName(String sterName) {
        this.sterName = sterName;
    }
}
