package com.company;

import java.util.*;

class InvalidConfig extends Exception{
    public InvalidConfig(String s){
        super(s);
    }
}

class Phone{
    private String processor ;
    private int ram ;
    private int storage ;

    Phone(String processor,int ram,int storage){
        this.processor = processor ;
        this.ram = ram ;
        this.storage = storage ;
    }

    @Override
    public String toString(){
        return processor + " " + String.valueOf(ram) + " " + String.valueOf(storage) + "\n";
    }
}

abstract class PhoneBulder{
    abstract String getProcessor() ;
    abstract void setProcessor(String model) throws InvalidConfig;
    abstract int getRam() ;
    abstract void setRam(int amountGB) throws InvalidConfig;
    abstract int getStorage() ;
    abstract void setStorage(int amountGB) throws InvalidConfig;
    abstract Phone build() ;
    abstract void addtoList(String type,String value) ;
    abstract void printList() ;
}

class type1 extends PhoneBulder{
    private String processor ;
    private int ram ;
    private int storage ;
    List<String[]> list = new ArrayList<>() ;

    void addtoList(String type,String value){
        String[] s = new String[2] ;
        s[0] = type ;
        s[1] = value ;

        list.add(s) ;

    }
    @Override
    String getProcessor() {
        return processor;
    }

    @Override
    void setProcessor(String model) throws InvalidConfig {
        try{
            if(model.equalsIgnoreCase("Qualcomm 820")){
                throw new InvalidConfig("Invalid Processor");
            }
            else{
                this.processor = model ;
            }
        }catch (InvalidConfig e){
            System.out.println(e.toString());
        }
    }
    @Override
    void printList(){
        for (String[] strings : list) {
            System.out.println(strings[0] + " " +strings[1]);
        }
    }
    @Override
    int getRam() {
        return ram;
    }

    @Override
    void setRam(int amountGB) {
        try{
            if(amountGB>8){
                throw  new InvalidConfig("Ram oversize") ;
            }
            else this.ram = amountGB ;
        }catch (InvalidConfig e){
            System.out.println(e.toString());
        }
    }

    @Override
    int getStorage() {
        return storage;
    }

    @Override
    void setStorage(int amountGB) {
        try{
            if(amountGB>64){
                throw  new InvalidConfig("Space oversize") ;
            }
            else this.storage = amountGB ;
        }catch (InvalidConfig e){
            System.out.println(e.toString());
        }
    }

    @Override
    Phone build() {
        return new Phone(getProcessor(),getRam(),getStorage()) ;
    }
}

class phoneConfigParser{
    private PhoneBulder phoneBulder = null ;
    phoneConfigParser(PhoneBulder p){
        this.phoneBulder = p ;
    }

    public void parse(String sample){
        String[] token = sample.split(",") ;
        for(int i=0;i<token.length;i = i+2){
            String type = token[i] ;
            String value = token[i+1] ;

            if(type.equalsIgnoreCase("processor")){
                try {
                    phoneBulder.setProcessor(value);
                    phoneBulder.addtoList(type,value);
                } catch (InvalidConfig invalidConfig) {
                    invalidConfig.printStackTrace();
                }
            }

            if(type.equalsIgnoreCase("ram")){
                try {
                    phoneBulder.setRam(Integer.parseInt(value));
                    phoneBulder.addtoList(type,value);
                } catch (InvalidConfig invalidConfig) {
                    invalidConfig.printStackTrace();
                }
            }

            if(type.equalsIgnoreCase("storage")){
                try {
                    phoneBulder.setStorage(Integer.parseInt(value));
                    phoneBulder.addtoList(type,value);
                } catch (InvalidConfig invalidConfig) {
                    invalidConfig.printStackTrace();
                }
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
	    PhoneBulder b = new type1() ;
	    new phoneConfigParser(b).parse("processor,810,ram,4,storage,32");
	    b.printList();
	    Phone p = b.build() ;
        System.out.println(p.toString()); ;
    }
}
