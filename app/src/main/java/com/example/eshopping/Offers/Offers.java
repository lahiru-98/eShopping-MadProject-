package com.example.eshopping.Offers;



public class Offers {

    String offerID;
    String startDate;
    String endDate;
    String offer;
    String des;


    public Offers(){

    }

    public Offers(String offerID, String startDate, String endDate, String offer, String des) {
        this.offerID = offerID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.offer = offer;
        this.des = des;
    }

    public String getOfferID() {
        return offerID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getOffer() {
        return offer;
    }

    public String getDes() {
        return des;
    }

    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
