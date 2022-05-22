package ui;

import java.util.ArrayList;

import javax.swing.text.DocumentFilter;

import model.*;

public class InitModel {
    
    public static ArrayList<Vehicle> createVehicles(){
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        Documents document1 = new Soat(12000, 2020, 120440);
        Documents document2 = new Tecnomechanic(30000, 2019, 4213);
        Documents document3 = new PropertyCard(21000, 2021);
        
        Documents [] documents = new Documents [3];
        documents [0] = document1;
        documents [1] = document2;
        documents [2] = document3;

        GasolineCar vehicle1 = new GasolineCar(200000, "Nissan", 2011, 70, 120 , VehicleType.USED, "hjk-088", documents, CarType.SEDAN, 4, true, GasolineType.DIESEL, 95);
        vehicles.add(vehicle1);

        Documents document6 = new Soat(12380, 2017, 124540);
        Documents document4 = new Tecnomechanic(10500, 2013, 4213);
        Documents document5 = new PropertyCard(21000, 2015);
        Documents [] documents1 = new Documents [3];
        documents1 [0] = document6;
        documents1 [1] = document4;
        documents1 [2] = document5;
        Motocycle vehicle2 = new Motocycle(20000000.0,"Honda", 2012, 125.0,2000, VehicleType.USED, "AUN-297", documents1, MotocycleType.CROSS, 90);
        vehicles.add(vehicle2);

        Documents document7 = new Soat(92380, 2019, 98540);
        Documents document8 = new Tecnomechanic(6000, 2011, 4213);
        Documents document9 = new PropertyCard(7800, 2005);
        Documents [] documents2 = new Documents [3];
        documents2 [0] = document7;
        documents2 [1] = document8;
        documents2 [2] = document9;
        ElectricCar vehicle3 = new ElectricCar(3000000, "ferrari", 2013, 458, 20000, VehicleType.USED, "JDK-735", documents2, CarType.SEDAN, 2, true, ChargerType.FAST, 48);
        vehicles.add(vehicle3);

        Documents document10 = new Soat(92380, 2019, 98540);
        Documents document11 = new Tecnomechanic(6000, 2011, 4213);
        Documents document12 = new PropertyCard(7800, 2005);
        Documents [] documents3 = new Documents [3];
        documents3 [0] = document10;
        documents3 [1] = document11;
        documents3 [2] = document12;
        HybridCar vehicle4 = new HybridCar(35000000, "Mini-Cooper", 2010, 150.0, 2000, VehicleType.USED, "VRE-385", documents3, CarType.SEDAN, 2, false, GasolineType.PREMIUM_GAS, 100, ChargerType.NORMAL, 72);
        vehicles.add(vehicle4);

        
        return vehicles;
    }

}
