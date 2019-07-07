package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new SportsCar(new BasicCar());
        Car car2 = new SportsCar(new LuxuryCar(new BasicCar()));
        car.assemble();
        car2.assemble();
    }
}


interface Car {
    void assemble();
}

class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling basic cars");
    }
}

class CarDecorator implements Car {
    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}

class SportsCar extends CarDecorator {

    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of sports car!!!");
    }
}

class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of luxury car!!!");
    }
}