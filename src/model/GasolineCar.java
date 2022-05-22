package model;

public class GasolineCar extends Car implements GasolineConsume {
    
    private GasolineType gasType;

    private double tankCapacity;

    private double gasolineConsume;

    public GasolineCar(double base_price,String mark,int model, double cilinderCapacity, int kilometers, VehicleType type, String licensePlate, Documents [] documents,CarType carType, int numDoors, boolean polarice,GasolineType gasType, int tankCapacity){

        super(base_price, mark, model, cilinderCapacity, kilometers, type, licensePlate, documents, carType, numDoors, polarice);
        this.tankCapacity = tankCapacity;
        this.gasType = gasType;

    }

    @Override
    public double calculateSellPrice(){
       return super.calculateSellPrice();
    }

    @Override
    public double gasolineConsume(){
        double out = tankCapacity*(cilinderCapacity/150);
        return out;
    }
    @Override
        public String toString(){
            return "Gasoline Car \n " + super.toString() +
            "Gas: " +  gasType + "\n" + 
            "Tank capacity : " + tankCapacity + "\n" +
            "Gasoline Consume:" + gasolineConsume();
        }



}
