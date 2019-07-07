package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shape tr1 = new Triangle();
        Shape tr2 = new Triangle();
        Shape circle = new Circle();

        Drawing drawing = new Drawing();
        drawing.addLeaf(tr1);
        drawing.addLeaf(tr2);
        drawing.addLeaf(circle);
        drawing.draw("red");

    }
}

//Base
abstract class Shape {

    abstract public void draw(String fillColor);

}


//Leaf
class Triangle extends Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Filling the triangle with color :: " + fillColor);
    }
}


class Circle extends Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Filling the circle with color :: " + fillColor);
    }
}

//Composite - which is a group of leafs to attain something

class Drawing extends Shape {

    private List<Shape> listOfLeaves = new ArrayList<>();

    @Override
    public void draw(String fillColor) {
        listOfLeaves.stream().forEach(s -> s.draw(fillColor));
    }

    public void addLeaf(Shape shape) {
        this.listOfLeaves.add(shape);
    }

    public void removeLeaf(Shape shape) {
        this.listOfLeaves.remove(shape);
    }

    public void clear() {
        this.listOfLeaves.clear();
    }


}