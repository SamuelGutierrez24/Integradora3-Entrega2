package ui;

import model.Sistem;
import model.Soat;

import java.util.Scanner;
   
public class Main{

        private Sistem sistem;

        private Scanner sc;

        public Main(){
            sistem = new Sistem(InitModel.createVehicles());
            sc = new Scanner(System.in);
        } 
        /* public Main(){
            sistem = new Sistem("hola");
            sc = new Scanner(System.in);
        } */

        public static void main (String [] a){

            System.out.println("Start the app");
		
		    Main ppal= new Main();
		
		    int option=0;


            do{
                option= ppal.showMenu();
                ppal.executeOperation(option);
                
            }while (option!=0);
            
        }
        
        public int showMenu() {
            int option=0;
    
            System.out.println(
                    "Selec an option:\n" +
                    "(1) Register a Vehicle\n" +
                    "(2) Make report \n"+
                    "(3) Documents of a vehicle\n"+
                    "(4) Show parking of old vehicles\n" + 
                    "(5) Reports parking \n" +
                    "(0) Para salir"
                    );
            option= sc.nextInt();
            sc.nextLine();
            return option;
        }
        
        public void executeOperation(int operation) {
            
            switch(operation) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                defaultVehicle() ;
                break;
            case 2:
                makeReport();
                break;
            case 3:
                documentsOfVehicle();
                break;
            case 4:
                showParking();
                break;
            case 5:
                reportParking();
                break;
            
            default:
                System.out.println("Error, opción no válida");
            
            }
        }
        

        public void defaultVehicle(){

            double price;
            System.out.println("Insert the base price of the vehicle :");
            price = sc.nextDouble();
            sc.nextLine();

            String brand;
            System.out.println("Inser the brand of the vehicle :");
            brand=sc.nextLine();

            int model;
            System.out.println("insert the model year of the vehicle :");
            model = sc.nextInt();
            sc.nextLine();

            double cilinder;
            System.out.println("Insert the cilinder capacity of the vehicle :");
            cilinder = sc.nextDouble();
            sc.nextLine();

             int isNew;
            do{
                System.out.println("The vehicle is new or used? (1) new and (2) Used :");
                isNew = sc.nextInt();
                sc.nextLine();

                 if(isNew != 1 && isNew !=2){
                    System.out.println("Invalid value");
                 }

            }while(isNew !=1 && isNew !=2);

            int kilometers;
            if(isNew == 1){
                kilometers = 0;
            }else{
                System.out.println("Insert the kilometers of the vehicle(If the vehicle is new insert 0) :");
                kilometers = sc.nextInt();
                sc.nextLine();
            }
           
            String plate;
            if(isNew == 1){
                plate = "";
            }else{
                System.out.println("Insert the licensePlate:");
                plate = sc.nextLine();
            }
            
            double soatPrice = -1;
            int soatYear = -1;
            double coverage = -1;
            boolean soat = false; 
            if(isNew == 2){

                System.out.println("The vehicle have Soat? (true or false) :");
                soat = sc.nextBoolean();
                sc.nextLine();
                if(soat == false){
                    soatPrice =-1;
                    soatYear = -1;
                    coverage = -1;
                }else{
                    System.out.println("Insert the price of the soat:");
                    soatPrice=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Insert the year of the soat :");
                    soatYear = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Insert the coverage of the soat:");
                    coverage =sc.nextDouble();
                    sc.nextLine();
                }
            
            }


            double tecnoPrice;
            int tecnoYear;
            double tecnoGases = 0;
            boolean tecno = false; 
            System.out.println("The vehicle have tecnomechanic? (true or false) :");
            tecno = sc.nextBoolean();
            sc.nextLine();
            if(tecno == false){
                tecnoPrice =-1;
                tecnoYear = -1;
                tecnoGases = -1;
            }else{
                System.out.println("Insert the price of the Tecnomechanic:");
                tecnoPrice=sc.nextDouble();
                sc.nextLine();
                System.out.println("Insert the year of the tecnomechanic :");
                tecnoYear = sc.nextInt();
                sc.nextLine();
                System.out.println("Insert the car gases of the tecnomechanic:");
                sc.nextDouble();
                sc.nextLine();
            }
//.
            double properPrice;
            int properYear;
            boolean property = true; 
            if(isNew == 1){
                property = false;
            }
            if(property == false){
                properPrice =-1;
                properYear = -1;
            }else{
                System.out.println("The car is used so... ");
                System.out.println("Insert the price of the property card:");
                properPrice=sc.nextDouble();
                sc.nextLine();
                System.out.println("Insert the year of the property card :");
                properYear = sc.nextInt();
                sc.nextLine();
            }
            int option;
            System.out.println("Insert what type of vehicle you want to register \n (1) Motocicle \n (2)Gas car \n (3) Electric car \n (4) Hybrid car");
            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1 :
                    registerMoto(price,brand,model,cilinder,kilometers,isNew,plate,soatPrice,soatYear,coverage,tecnoPrice,tecnoYear,tecnoGases,properPrice,properYear);
                    break;
                case 2:
                    registerGasCar(price,brand,model,cilinder,kilometers,isNew,plate,soatPrice,soatYear,coverage,tecnoPrice,tecnoYear,tecnoGases,properPrice,properYear);
                    break;
                case 3:
                    registeredElectricCar(price,brand,model,cilinder,kilometers,isNew,plate,soatPrice,soatYear,coverage,tecnoPrice,tecnoYear,tecnoGases,properPrice,properYear);
                    break;
                case 4:
                    registeredhybridCar(price,brand,model,cilinder,kilometers,isNew,plate,soatPrice,soatYear,coverage,tecnoPrice,tecnoYear,tecnoGases,properPrice,properYear);
                    break;
                default:
                System.out.println("invalid option.");
                    break;
            }




        }
       
        public void registerMoto(double price, String brand, int model, double cilinder, int kilometers, int isNew, String plate,double soatPrice, int soatYear, double coverage,double tecnoPrice,int tecnoYear,double tecnoGases,double properPrice,int properYear){

            int motoType;
            System.out.println("Insert the moto type \n (1) Estandar \n (2) Sport \n (3) Scooter \n (4) Cross ");
            motoType = sc.nextInt();
            sc.nextLine();

            int tank;
            System.out.println("Insert the tank capacity of the moto:");
            tank = sc.nextInt();
            sc.nextLine();

            System.out.println(sistem.addMotocycle(price,brand, model, cilinder, kilometers, isNew, plate, motoType, tank, soatPrice, soatYear, coverage, tecnoPrice, tecnoYear, tecnoGases, properPrice, properYear));


        }

        public void registerGasCar(double price, String brand, int model, double cilinder, int kilometers, int isNew, String plate,double soatPrice, int soatYear, double coverage,double tecnoPrice,int tecnoYear,double tecnoGases,double properPrice,int properYear){

            int doors;
            System.out.println("Insert the number of doors :");
            doors = sc.nextInt();
            sc.nextLine();

            boolean isPolarice;
            System.out.println("¿The car is polarice? (true or false)");
            isPolarice= sc.nextBoolean();
            sc.nextLine();
            
            int gasType;
            System.out.println("Insert the type of gas the car use \n (1) Diesel \n (2) Premium \n (3) Regular");
            gasType = sc.nextInt();
            sc.nextLine();

            int carType;
            System.out.println("Insert the car type \n (1) Sedan \n (2) Truck ");
            carType = sc.nextInt();
            sc.nextLine();

            int tank;
            System.out.println("Insert the tank capacity of the car:");
            tank = sc.nextInt();
            sc.nextLine();



            System.out.println(sistem.addGasCar(price, brand, model, cilinder, kilometers, isNew, plate, carType, doors, isPolarice, gasType, tank, soatPrice, soatYear, coverage, tecnoPrice, tecnoYear, tecnoGases, properPrice, properYear));

        }

        public void registeredElectricCar(double price, String brand, int model, double cilinder, int kilometers, int isNew, String plate,double soatPrice, int soatYear, double coverage,double tecnoPrice,int tecnoYear,double tecnoGases,double properPrice,int properYear){

            int doors;
            System.out.println("Insert the number of doors :");
            doors = sc.nextInt();
            sc.nextLine();

            boolean isPolarice;
            System.out.println("¿The car is polarice? (true or false)");
            isPolarice= sc.nextBoolean();
            sc.nextLine();

            int carType;
            System.out.println("Insert the car type \n (1) Sedan \n (2) Truck ");
            carType = sc.nextInt();
            sc.nextLine();

            int charger;
            System.out.println("Insert the charger type \n (1) Fast \n (2) Normal ");
            charger = sc.nextInt();
            sc.nextLine();

            double duration;
            System.out.println("Insert the car battery duration");
            duration = sc.nextDouble();
            sc.nextLine();

            System.out.println(sistem.addElectricCar(price, brand, model, cilinder, kilometers, isNew, plate, carType, doors, isPolarice, charger, duration, soatPrice, soatYear, coverage, tecnoPrice, tecnoYear, tecnoGases, properPrice, properYear));


        }

        public void registeredhybridCar(double price, String brand, int model, double cilinder, int kilometers, int isNew, String plate,double soatPrice, int soatYear, double coverage,double tecnoPrice,int tecnoYear,double tecnoGases,double properPrice,int properYear){

            int doors;
            System.out.println("Insert the number of doors :");
            doors = sc.nextInt();
            sc.nextLine();

            boolean isPolarice;
            System.out.println("¿The car is tinted? (true or false)");
            isPolarice= sc.nextBoolean();
            sc.nextLine();

            int carType;
            System.out.println("Insert the car type \n (1) Sedan \n (2) Truck ");
            carType = sc.nextInt();
            sc.nextLine();

            int charger;
            System.out.println("Insert the charger type \n (1) Fast \n (2) Normal ");
            charger = sc.nextInt();
            sc.nextLine();

            double duration;
            System.out.println("Insert the car battery duration");
            duration = sc.nextDouble();
            sc.nextLine();

            int gasType;
            System.out.println("Insert the type of gas the car use \n (1) Diesel \n (2) Premium \n (3) Regular");
            gasType = sc.nextInt();
            sc.nextLine();

            int tank;
            System.out.println("Insert the tank capacity of the car:");
            tank = sc.nextInt();
            sc.nextLine();

            System.out.println(sistem.addHybridCar(price, brand, model, cilinder, kilometers, isNew, plate, carType, doors, isPolarice, gasType, tank, charger, duration, soatPrice, soatYear, coverage, tecnoPrice, tecnoYear, tecnoGases, properPrice, properYear));


        }

        public void makeReport(){

            int option;
            System.out.println("Make a report acording to:" +"\n" +
            "(1) Vehicle type \n" +
            "(2) Fuel type \n" +
            "(3) Used or new cars");
            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    reportVehicheType();
                break;
                case 2:
                    reportFuelType();
                break;
                case 3:
                    reportUsedOrNew();
                break;
                default :
                System.out.println("Invald option");
                break;
            }

        }

        public void reportVehicheType(){
            //Dios mio....
            int option2;
            System.out.println("(1) Cars \n (2) Motocycles");
            option2 = sc.nextInt();
            sc.nextLine();

            if(option2 == 2){
               System.out.println(sistem.showOnlyMotos());
            }else{
                int option3;
                System.out.println("Select a car type: \n (1) Gas car \n (2) Electric car \n (3) Hybrid car ");
                option3 = sc.nextInt();
                sc.nextLine();

                if(option3 == 1){
                    System.out.println(sistem.showGasCars());
                }
                if(option3 == 2){
                    System.out.println(sistem.showElectricCars());   
                }
                if(option3 ==3){
                    System.out.println(sistem.showHybridCars());
                }
            }
        }

        public void reportFuelType(){

            int option;
            System.out.println("Selec type of fuel: \n (1) Gas \n (2) Battery"); 
            option = sc.nextInt();
            sc.nextLine();     
            if(option == 1 || option == 2){
                if(option == 1){
                System.out.println(sistem.showFuelGasCars());
                }
                if(option == 2){
                    System.out.println(sistem.showBatteryCars());
                }
            }else{
                System.out.println("Invalid option");
            }

        }

        public void reportUsedOrNew(){

            int option;
            System.out.println("Selct (1) New vehicles \n (2) Used vehicles ");
            option = sc.nextInt();
            sc.nextLine();

            if(option == 1 || option == 2){

                if(option==1){
                    System.out.println(sistem.showNewVehicles());
                }else{
                    System.out.println(sistem.showUsedVehicles());
                }

            }
        }

        public void documentsOfVehicle(){
            System.out.println("Insert the ID of the vehicle :");
            int id = sc.nextInt();

            System.out.println(sistem.documentsReport(id));
        }

        public void showParking(){
            System.out.println(sistem.showParking());
        }

        public void reportParking(){
            System.out.println("With what criteria?\n (1)Range of years \n (2) Newest and oldest vehicle \n (3)Busy porcentage  ");
            int option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1 : 
                    reportRange();
                break;
                case 2:
                     reportNewOld(); 
                break;
                case 3 :
                     reportPorcentage(); 
                break;
                default:
                    System.out.println("Invalid option.");
                break;
            }
        }

        public void reportRange(){
            System.out.println("Insert the range of years starting in 2014:");
            System.out.println("Firt the young year (En español es que me digite el año mas reciente del rango):");
            int year1 = sc.nextInt();
            sc.nextLine();
            System.out.println("Second the older year(En español es que me digite el año mas antiguo del rango): ");
            int year2 = sc.nextInt();
            sc.nextLine();
            System.out.println(sistem.reportRange(year1,year2));
        }
        public void reportNewOld(){
            System.out.println(sistem.reportNewParking());
        }
        public void reportPorcentage(){
            System.out.println(sistem.reportPorcentage());
        }


        
    }