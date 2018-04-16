package com.company;

interface Engine{
    void getEngineName() ;
}

class AccordEngine implements Engine{
    @Override
    public void getEngineName(){
        System.out.println("Accord Engine");
    }
}

class CivicEngine implements Engine{
    @Override
    public void getEngineName(){
        System.out.println("Civic Engine");
    }
}




interface Tranmission{
    void getTransmissionName() ;
}

class AccordTransmission implements Tranmission{

    @Override
    public void getTransmissionName() {
        System.out.println("Accord Transmission");
    }
}


class CivicTransmission implements Tranmission{

    @Override
    public void getTransmissionName() {
        System.out.println("Civic Transmission");
    }
}


interface HondaFactory{
    Engine createEngine() ;
    Tranmission createTranmission() ;
}

class AccordFactory implements HondaFactory{

    @Override
    public Engine createEngine() {
        return new AccordEngine();
    }

    @Override
    public Tranmission createTranmission() {
        return new AccordTransmission();
    }
}

class CivicFactory implements HondaFactory{

    @Override
    public Engine createEngine() {
        return new CivicEngine();
    }

    @Override
    public Tranmission createTranmission() {
        return new CivicTransmission();
    }
}

class AbstructFactory{
    HondaFactory getFactory(String model){
        if(model.equalsIgnoreCase("Accord")){
            return new AccordFactory() ;
        }
        else if(model.equalsIgnoreCase("Civic")){
            return new CivicFactory() ;
        }
        else return null ;

    }
}

public class Main {

    public static void main(String[] args) {
        HondaFactory factory = new AbstructFactory().getFactory("Civic") ;
        Engine e = factory.createEngine() ;
        Tranmission t = factory.createTranmission() ;
        e.getEngineName();
        t.getTransmissionName();

    }
}
