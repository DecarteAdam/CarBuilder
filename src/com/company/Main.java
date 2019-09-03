package com.company;

public class Main {

    public static void main(String[] args) {

        Car car = new CarBuilder()
                .buildMake("BMW")
                .buildTransmition(Transmition.AUTO)
                .buildMaxSpeed(280)
                .build();
        System.out.println(car);


    }
}


enum Transmition{
    MANUAL, AUTO
}

class Car{
    String make;
    Transmition transmition;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmition(Transmition transmition) {
        this.transmition = transmition;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmition=" + transmition +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}


class CarBuilder{                                           // class "Builder" qui va construire l'objet "Car" avec les valeurs par defaut
    String m = "Default";                                   //Il contient les attributs "m = marque"
    Transmition t = Transmition.MANUAL;                     // attribut "t = transmition"
    int s = 120;                                            // attribut "s = vitesse max


    CarBuilder buildMake(String m){                         //La methode qui remplace les valeurs par defaut. buildMake remplace la marque
        this.m = m;
        return this;
    }

    CarBuilder buildTransmition(Transmition t){             //buildMake remplace la tranmition
        this.t = t;
        return this;
    }

    CarBuilder buildMaxSpeed(int s){                        //buildMake remplace la vitesse max
        this.s = s;
        return this;
    }

    Car build(){                                        //Class build est la méthode de la class 'CarBuilder' qui va retourner l'objet 'Car' avec les nouveaux parametres
        Car car = new Car();
        car.setMake(m);
        car.setTransmition(t);
        car.setMaxSpeed(s);
        return car;
    }
}