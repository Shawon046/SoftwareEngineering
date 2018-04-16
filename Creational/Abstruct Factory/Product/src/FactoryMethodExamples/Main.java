package FactoryMethodExamples;

interface ProductA{
    void printProductPartName() ;
}

class ProductAX implements ProductA{

    @Override
    public void printProductPartName() {
        System.out.println("Product AX");
    }
}

class ProductAY implements ProductA{

    @Override
    public void printProductPartName() {

        System.out.println("Product AY");
    }
}

interface ProductB{
    void printProductPartName() ;
}

class ProductBX implements ProductB{

    @Override
    public void printProductPartName() {
        System.out.println("Product BX");
    }
}

class ProductBY implements ProductB{

    @Override
    public void printProductPartName() {

        System.out.println("Product BY");
    }
}

interface Product{
    ProductA createProductA() ;
    ProductB createProductB() ;
}

class ProductX implements Product{

    @Override
    public ProductA createProductA() {
        return new ProductAX();
    }

    @Override
    public ProductB createProductB() {
        return new ProductBX();
    }
}

class ProductY implements Product{

    @Override
    public ProductA createProductA() {
        return new ProductAY();
    }

    @Override
    public ProductB createProductB() {
        return new ProductBY();
    }
}


class AbstructFactory{
    Product getProduct(String name){
        if(name.equalsIgnoreCase("X")){
            return new ProductX() ;
        }
        if(name.equalsIgnoreCase("Y")){
            return new ProductY() ;
        }
        else return null ;
    }
}
public class Main {

    public static void main(String[] args){
        Product p = new AbstructFactory().getProduct("X") ;
        ProductA a = p.createProductA() ;
        ProductB b = p.createProductB() ;
        a.printProductPartName();
        b.printProductPartName();
    }
}
