package com.company;

import java.lang.String ;

interface paymentMethod{
    void setAmount(String id,double amount) ;
    void processPayment() ;
    String getStatement() ;
}

class CashOnDelivery implements paymentMethod{
    private String type ;
    private double amount ;

    public CashOnDelivery(){
          type = "Cash on delivery" ;
    }

    @Override
    public void setAmount(String id, double amount) {
        this.amount = amount ;
    }

    @Override
    public void processPayment() {
    }

    @Override
    public String getStatement() {
        return "PaymentMethod: "+type+" "+ amount;
    }
}

class CreditCard implements paymentMethod{
    private String type ;
    private String cardno ;
    private double amount ;

    public CreditCard(){
        type = "Credit Card" ;
    }

    @Override
    public void setAmount(String id, double amount) {
        this.cardno = id ;
        this.amount = amount ;
    }

    @Override
    public void processPayment() {
        //do the process
    }

    @Override
    public String getStatement() {
        return "PaymentMethod: "+type+ " - " + cardno + " - " + amount  ;
    }
}

class bKash implements paymentMethod{
    String mobilenumber ;
    double amount ;
    String type ;

    bKash(){
        this.type = "bKash" ;
    }
    @Override
    public void setAmount(String id, double amount) {
        this.mobilenumber = id ;
        this.amount = amount ;
    }

    @Override
    public void processPayment() {
        //apply procedure to send data to database
    }

    @Override
    public String getStatement() {
        return "PaymentMethod: "+type+ " - " + mobilenumber + " - " + amount  ;
    }
}


class paymentMethodFactory{
    paymentMethod getPaymentMethod(String type){
        if(type.equalsIgnoreCase("CashOnDelivery")){
            return new CashOnDelivery() ;
        }

        else if(type.equalsIgnoreCase("CreditCard")){
            return new CreditCard() ;
        }
        else if(type.equalsIgnoreCase("bKash")){
            return new bKash() ;
        }
        else return null ;
    }
}


public class Main {

    public static void main(String[] args) {
        paymentMethod p = new paymentMethodFactory().getPaymentMethod("CreditCard") ;
        p.setAmount("VISA/0074",1000);
        System.out.println(p.getStatement());
        p = new paymentMethodFactory().getPaymentMethod("CashOnDelivery") ;
        p.setAmount("",500);
        System.out.println(p.getStatement());
        p = new paymentMethodFactory().getPaymentMethod("bKash") ;
        p.setAmount("01780499787",500);
        System.out.println(p.getStatement());
    }
}
