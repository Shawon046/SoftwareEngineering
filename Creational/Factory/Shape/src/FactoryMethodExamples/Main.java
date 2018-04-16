package FactoryMethodExamples;


interface Shape{
    String getShapeName() ;
}

class Circle implements Shape{

    @Override
    public String getShapeName() {
        return "Circle";
    }
}

class Triangle implements Shape{

    @Override
    public String getShapeName() {
        return "Triangle";
    }
}

class ShapeFactory{
    Shape getShape(String name){
        if(name.equalsIgnoreCase("Circle")){
            return new Circle() ;
        }
        if(name.equalsIgnoreCase("Triangle")){
            return new Triangle() ;
        }
        else return null ;

    }
}
public class Main {

    public static void main(String[] args) {
	    Shape shape = new ShapeFactory().getShape("Circle") ;
        System.out.println(shape.getShapeName());
        shape = new ShapeFactory().getShape("Triangle") ;
        System.out.println(shape.getShapeName());
    }
}
