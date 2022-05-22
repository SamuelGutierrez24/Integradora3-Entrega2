package model;

import java.util.ArrayList;

import ui.InitModel;

    public class Sistem{

        private String hola;

        private ArrayList<Vehicle>vehicles;

        private Vehicle [][] parking;

        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_RESET = "\u001B[0m";

        public Sistem(String hola){
            this.hola = hola;
            vehicles = new ArrayList<Vehicle>();
            parking = new Vehicle [10][5];
        }
        public Sistem(ArrayList<Vehicle> vehicles){
            this.vehicles = vehicles;
            parking = new Vehicle [10][5];
            for(int i = 0;i<vehicles.size();i++){
                addCarToParking(vehicles.get(i));
               /* if(answer == true){
                   out = "";
               }else{
                   out = "The parking is full in that column";
               } */
            }
        }

        public String addMotocycle(double base_price,String mark,int model, double cilinderCapacity, int kilometers, int type, String licensePlate,int motoType, int tankCapacity,double soatPrice, int soatYear, double coverage, double tecnoPrice,int tecnoYear, double carGases,double properPrice,int properYear){

            String out=""; 


            VehicleType isUsed = null;

            switch(type){
                case 1 :
                    isUsed = VehicleType.NEW;
                break;
                case 2 :
                    isUsed = VehicleType.USED;
                break;
            }

            MotocycleType typeMoto = null;

            switch(motoType){
                case 1 :
                    typeMoto = MotocycleType.ESTANDAR;
                break;
                case 2 :
                    typeMoto = MotocycleType.SPORT;
                break;
                case 3 :
                    typeMoto = MotocycleType.SCOOTER;
                break;
                case 4 :
                    typeMoto = MotocycleType.CROSS;
                break;
            }

           // LLenar documentos
            Documents [] documents = new Documents[3];

            if(soatPrice != -1 && soatYear != -1){
                documents [0] = new Soat(soatPrice,soatYear,coverage);
            }

            if(tecnoPrice != -1 && tecnoYear != -1){
                documents [1] = new Tecnomechanic(tecnoPrice, tecnoYear, carGases);
            }
            if(properPrice != -1 && properYear != -1){
                documents[2] = new PropertyCard(properPrice, properYear);
            }


           Motocycle aMoto = new Motocycle(base_price, mark, model, cilinderCapacity, kilometers, isUsed, licensePlate, documents, typeMoto, tankCapacity);

           
            vehicles.add(aMoto);

            boolean park = true;
            if(model <= 2014){
            park = addCarToParking(aMoto);
            }
            
            if(park == false){
            out += "The vehiecle can't be add to the parking because his column is already full, Please add more space in the parking. \n";
            }
            out += "ID of the moto: " + vehicles.indexOf(aMoto) + " \n  The Moto was succesfully registered! \n";
            return out;

        }
        
        
       
        public boolean proveType(int type){

            boolean out = false;

            if(type != 0){
                if(type == 1 || type == 2){
                    out = true;
                }
            }
            return out;
        }

        public boolean proveMotoType(int motoType){
            
            boolean out = false;

            if(motoType!=0){
                if(motoType == 1 || motoType == 2 || motoType == 3 || motoType==3){
                    out = true;
                }
            }
            return out;

        }

        public String addGasCar(double base_price,String mark,int model, double cilinderCapacity, int kilometers, int type, String licensePlate,int carType, int numDoors, boolean polarice,int gasType, int tankCapacity, double soatPrice, int soatYear, double coverage, double tecnoPrice,int tecnoYear, double carGases,double properPrice,int properYear){

            String out=""; 

            

            VehicleType isUsed = null;

            switch(type){
                case 1 :
                    isUsed = VehicleType.NEW;
                break;
                case 2 :
                    isUsed = VehicleType.USED;
                break;
            }

            CarType typeCar = null;

            switch(carType){
                case 1 :
                    typeCar = CarType.SEDAN;
                break;
                case 2:
                    typeCar = CarType.TRUCK;
                break;
            }

            GasolineType gas = null;

            switch(gasType){
                case 1:
                    gas = GasolineType.DIESEL;
                break;
                case 2 :
                    gas = GasolineType.PREMIUM_GAS;
                break;
                case 3:
                    gas = GasolineType.REGULAR_GAS;
                break;

            }

            // LLenar documentos
            Documents [] documents = new Documents[3];

            if(soatPrice != -1 && soatYear != -1){
                documents [0] = new Soat(soatPrice,soatYear,coverage);
            }

            if(tecnoPrice != -1 && tecnoYear != -1){
                documents [1] = new Tecnomechanic(tecnoPrice, tecnoYear, carGases);
            }
            if(properPrice != -1 && properYear != -1){
                documents[2] = new PropertyCard(properPrice, properYear);
            }

            GasolineCar aCar = new GasolineCar(base_price, mark, model, cilinderCapacity, kilometers, isUsed, licensePlate,documents , typeCar, numDoors, polarice, gas, tankCapacity);
            
            vehicles.add(aCar);
           
            boolean park = true;
            if(model <= 2014){
            park = addCarToParking(aCar);
            }
            
            if(park == false){
            out += "The vehiecle can't be add to the parking because his column is already full, Please add more space in the parking. \n";
            }
            
             out += " ID of the car:  " + vehicles.indexOf(aCar) + " \n The car was successfully registered! \n";
            return out;
        }

        public String addElectricCar(double base_price,String mark,int model, double cilinderCapacity, int kilometers, int type, String licensePlate,int carType, int numDoors, boolean polarice,int charger, double batteryDuration,double soatPrice, int soatYear, double coverage, double tecnoPrice,int tecnoYear, double carGases,double properPrice,int properYear){
            
            String out = "";

        
            VehicleType isUsed = null;

            switch(type){
                case 1 :
                    isUsed = VehicleType.NEW;
                break;
                case 2 :
                    isUsed = VehicleType.USED;
                break;
            }

            CarType typeCar = null;

            switch(carType){
                case 1 :
                    typeCar = CarType.SEDAN;
                break;
                case 2:
                    typeCar = CarType.TRUCK;
                break;
            }

            ChargerType typeCharger = null;

            switch(charger){
                case 1:
                    typeCharger = ChargerType.FAST;
                break;
                case 2:
                    typeCharger = ChargerType.NORMAL;
                break;
            }


            // LLenar documentos
            Documents [] documents = new Documents[3];

            if(soatPrice != -1 && soatYear != -1){
                documents [0] = new Soat(soatPrice,soatYear,coverage);
            }

            if(tecnoPrice != -1 && tecnoYear != -1){
                documents [1] = new Tecnomechanic(tecnoPrice, tecnoYear, carGases);
            }
            if(properPrice != -1 && properYear != -1){
                documents[2] = new PropertyCard(properPrice, properYear);
            }

            ElectricCar aElectric = new ElectricCar(base_price, mark, model, cilinderCapacity, kilometers, isUsed, licensePlate, documents, typeCar, numDoors, polarice, typeCharger, batteryDuration);

            vehicles.add(aElectric);

            boolean park = true;
            if(model <= 2014){
            park = addCarToParking(aElectric);
            }
            
            if(park == false){
            out += "The vehiecle can't be add to the parking because his column is already full, Please add more space in the parking. \n";
            }
            
            out += "ID of the car: " + vehicles.indexOf(aElectric) + " \n The Electric car was successfully registered! \n";
                
            return out;

        }

        public String addHybridCar(double base_price,String mark,int model, Double cilinderCapacity, int kilometers, int type, String licensePlate,int carType, int numDoors, boolean polarice,int gasType, int tankCapacity,int charger, double batteryDuration,double soatPrice, int soatYear, double coverage, double tecnoPrice,int tecnoYear, double carGases,double properPrice,int properYear){

            String out = "";


            VehicleType isUsed = null;

            switch(type){
                case 1 :
                    isUsed = VehicleType.NEW;
                break;
                case 2 :
                    isUsed = VehicleType.USED;
                break;
            }

            CarType typeCar = null;

            switch(carType){
                case 1 :
                    typeCar = CarType.SEDAN;
                break;
                case 2:
                    typeCar = CarType.TRUCK;
                break;
            }

            ChargerType typeCharger = null;

            switch(charger){
                case 1:
                    typeCharger = ChargerType.FAST;
                break;
                case 2:
                    typeCharger = ChargerType.NORMAL;
                break;
            }

            GasolineType gas = null;

            switch(gasType){
                case 1:
                    gas = GasolineType.DIESEL;
                break;
                case 2 :
                    gas = GasolineType.PREMIUM_GAS;
                break;
                case 3:
                    gas = GasolineType.REGULAR_GAS;
                break;

            }

            // LLenar documentos
            Documents [] documents = new Documents[3];

            if(soatPrice != -1 && soatYear != -1){
                documents [0] = new Soat(soatPrice,soatYear,coverage);
            }

            if(tecnoPrice != -1 && tecnoYear != -1){
                documents [1] = new Tecnomechanic(tecnoPrice, tecnoYear, carGases);
            }
            if(properPrice != -1 && properYear != -1){
                documents[2] = new PropertyCard(properPrice, properYear);
            }

            HybridCar aHybridCar = new HybridCar(base_price, mark, model, cilinderCapacity, kilometers, isUsed, licensePlate, documents, typeCar, numDoors, polarice, gas, tankCapacity, typeCharger, batteryDuration);
            
            vehicles.add(aHybridCar);

            boolean park = true;
            if(model <= 2014){
            park = addCarToParking(aHybridCar);
            }
            
            if(park == false){
            out += "The vehiecle can't be add to the parking because his column is already full, Please add more space in the parking. \n";
            }

            out += "ID of the car: " + vehicles.indexOf(aHybridCar) + " \n The hybrid car was seccessfully registered \n";

            return out;
        }

        public String showOnlyMotos(){
            
            String out = "";

            for(int i = 0;i<vehicles.size();i++){
                if(vehicles.get(i) instanceof Motocycle){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String showGasCars(){
            String out = "";

            for(int i = 0;i<vehicles.size();i++){
                if(vehicles.get(i) instanceof GasolineCar){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String showElectricCars(){
            String out = "";

            for(int i = 0;i<vehicles.size();i++){
                if(vehicles.get(i) instanceof ElectricCar){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String showHybridCars(){
            String out = "";
            
            for(int i = 0;i<vehicles.size();i++){
                if(vehicles.get(i) instanceof HybridCar){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String showFuelGasCars(){
           String out = "";
           
            for(int i = 0;i<vehicles.size();i++){
                if(vehicles.get(i) instanceof GasolineConsume){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String showBatteryCars(){
            String out = "";

            for(int i = 0;i<vehicles.size();i++){
                if(vehicles.get(i) instanceof BatteryConsume){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String showNewVehicles(){
            String out = "";

            for(int i = 0;i<vehicles.size();i++){
                VehicleType isNew = vehicles.get(i).getVehicleType();
                if(isNew == VehicleType.NEW){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String showUsedVehicles(){
            String out = "";

            for(int i = 0;i<vehicles.size();i++){
                VehicleType isNew = vehicles.get(i).getVehicleType();
                if(isNew == VehicleType.USED){
                    out += vehicles.get(i).toString() + "\n";
                }
            }
            return out;
        }

        public String documentsReport(int index){

            String out = "";

            if(vehicles.get(index) == null){
                out= "The ID insert is not found :(";
            }else{
                out = vehicles.get(index).reportDocu();
            }

            return out;
        }
        public boolean addCarToParking(Vehicle vehicle){

            boolean answer = true;

            int year = vehicle.getModel();
            VehicleType isUsed = vehicle.getVehicleType();
            int position = getPositionForParking(year);
            if(position != -1){
              
                if(year <=2014 && isUsed == VehicleType.USED){

                    if(year == 2014){
                        parking[position][0] = vehicle;
                    }
                    if(year == 2013){
                        parking[position][1] = vehicle;
                    }
                    if(year == 2012){
                        parking[position][2] = vehicle;
                    }
                    if(year == 2011){
                        parking[position][3] = vehicle;
                    }
                    if(year<2011){
                        parking[position][4] = vehicle;
                    }
                }else{
                    answer = false;
                }
            }else{
                answer = false;
            }
            
            return answer;
        }

        public int getPositionForParking(int year){
            int out = -1;
            int columna = -1;

            if(year == 2014){
                columna = 0;
            }
            if(year == 2013){
                columna = 1;
            }
            if(year == 2012){
                columna = 2;
            }
            if(year == 2011){
                columna = 3;
            }
            if(year <= 2010){
                columna = 4;
            }
            if(columna != -1){
                for(int i = 0;i<parking.length && out== -1;i++){
                
                    if(parking[i][columna] == null){
                        out=i;
                    }
                }
            }
            return out;

        }

        public String showParking(){
            String out = "";
            String instance = null;
            out += "\n M = Moto \n G = Gas Car \n E = Electric Car \n H = Hybrid Car\n\n";
            out += "-----2014---------2013---------2012---------2011---------2010------";
            for (int i=0; i< parking.length; i++ ) { // filas numbers.length
                out += "\n";
                out +="-----------------------------------------------------------------\n";
                for (int j = 0; j <parking[0].length; j++) { //columnas numbers[0].length
                   if(parking[i][j] != null){
                        
                        instance = null;

                        if(parking[i][j] instanceof Motocycle){
                            instance = "M";
                        }
                        if(parking[i][j] instanceof GasolineCar){
                            instance = "G";
                        }
                        if(parking[i][j] instanceof ElectricCar){
                            instance = "E";
                        }
                        if(parking[i][j] instanceof HybridCar){
                            instance = "H";
                        }
                        
                        out += "|     " + instance + "     |" ;
                        
                    }else{
                        out += "|           |" ;
                    }
                }
            
            }
            return out;
        }

        public String reportRange(int year1,int year2){
            String out = "\nInformation of vehicles in parking in this range of years: \n \n";
            
            int range = 0;

            if(year2<2010){
            year2 = 2010;
            }
            range = year1-year2;

            
            int firts = -1;
            if(year1>=2010){
                switch(year1){
                    case 2014:
                        firts = 0;
                    break;
                    case 2013:
                        firts = 1;
                    break;
                    case 2012:
                        firts = 2;
                    break;
                    case 2011:
                        firts = 3;
                    break;
                    case 2010 :
                        firts =4;
                    break;
                }
            }else{
                firts = 4;
            }
            int count = 1;
            for (int i=0; i< parking.length; i++ ) { // filas numbers.length
               for (int j = firts ; j <range+1; j++) { //columnas numbers[0].length
                   if(parking[i][j] != null){
                       out+="\n Vehicle #" + count;
                        out += "\n" + parking[i][j].toString() + "\n\n";
                        count++;
                        
                    }
                }
            
            }




            return out;
        }
        
        public String reportNewParking(){
            String out = "";
            out += "\nMOST NEW OR NEWEST\n\n";
            int count = 1;
            int newest = -1;
            //Buscamos el mas nuevo;
            for (int i=0; i< parking.length; i++ ) { // filas numbers.length
                for (int j = 0; j <parking[0].length; j++) { //columnas numbers[0].length
                    if(parking[i][j] != null &&  newest<parking[i][j].getModel()){
                        newest = parking[i][j].getModel();
                     }
                 }
            }
            //Imprimimos los mas nuevos
            for (int i=0; i< parking.length; i++ ) { // filas numbers.length
                for (int j = 0 ; j <parking[0].length; j++) { //columnas numbers[0].length
                    if(parking[i][j] != null && parking[i][j].getModel()==newest){
                        
                            out+="\n Vehicle #" + count;
                            out += "\n" + parking[i][j].toString() + "\n\n";
                            count++;
                         
                     }
                 }
             
             }
             
             out += "\nMOST OLD OR OLDEST VEHICLE\n\n";
             int count2 = 1;
             int oldest = 2014;
             //buscamos el autoo mas viejo
             for (int i=0; i< parking.length; i++ ) { // filas numbers.length
                for (int j = 0; j <parking[0].length; j++) { //columnas numbers[0].length
                    if(parking[i][j] != null && oldest>parking[i][j].getModel()){
                        oldest = parking[i][j].getModel();
                    
                    }
                }
            }
            //Imprimimos los mas viejos
            for (int i=0; i< parking.length; i++ ) { // filas numbers.length
                for (int j = 0 ; j <parking[0].length; j++) { //columnas numbers[0].length
                    if(parking[i][j] != null && parking[i][j].getModel()==oldest){
                        
                            out+="\n Vehicle #" + count2;
                            out += "\n" + parking[i][j].toString() + "\n\n";
                            count2++;
                         
                     }
                 }
             
             }

              
            return out;
        }

        public String reportPorcentage(){
            String out = "";
            int count=0;
            double porcentage =0;
            for (int i=0; i< parking.length; i++ ) { // filas numbers.length
                for (int j = 0 ; j <parking[0].length; j++) { //columnas numbers[0].length
                    if(parking[i][j] != null){
                        count++;
                     }
                }
             }
             porcentage = (count*100)/50;
             out = "The parking is: " + porcentage + "% busy\n";

            return out;
        }
    }

        
    