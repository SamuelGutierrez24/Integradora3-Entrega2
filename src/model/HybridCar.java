package model;

public class HybridCar extends Car implements GasolineConsume,BatteryConsume {

    private ChargerType charger;

    private double batteryDuration;

    private double batteryConsume;

    private GasolineType gasType;

    private double tankCapacity;

    private double gasolineConsume;

    public HybridCar(double base_price,String mark,int model, Double cilinderCapacity, int kilometers, VehicleType type, String licensePlate, Documents [] documents,CarType carType, int numDoors, boolean polarice,GasolineType gasType, int tankCapacity,ChargerType charger, double batteryDuration){

        super(base_price, mark, model, cilinderCapacity, kilometers, type, licensePlate, documents, carType, numDoors, polarice);
        this.charger = charger;
        this.batteryDuration = batteryDuration;
        this.gasType = gasType;
        this.tankCapacity = tankCapacity;

    }

    @Override
    public double calculateSellPrice(){
        double cost = super.calculateSellPrice();

        double hybMore = base_price*0.15;

        cost += hybMore;

        return cost;
    }
    
    @Override
    public double gasolineConsume(){
        double out = 0;

        out = tankCapacity*(cilinderCapacity/180);

        return out;
    }

    @Override
    public double batteryConsume(){
        double out = 0;

        if(charger == ChargerType.FAST){
            out = batteryDuration*(cilinderCapacity/200);
        }
        if(charger == ChargerType.NORMAL){
            out = (batteryDuration+7)*(cilinderCapacity/200);
        }

        return out;
    }
    @Override
        public String toString(){
            return "Hybrid Car \n " + super.toString() +
            "charger type : " +  charger + "\n" +
            "Battery duration : " + batteryDuration + "\n" +
            "Tank capacity : " + tankCapacity +"\n" +
            "Gas : " + gasType + "\n" +
            "Gasoline consume :" + gasolineConsume() + "\n" +
            "battery Consume : " + batteryConsume();
        }
    
}
