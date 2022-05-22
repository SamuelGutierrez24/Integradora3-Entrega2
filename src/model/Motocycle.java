    package model;
    
    public class Motocycle extends Vehicle implements GasolineConsume {
        
        private MotocycleType motoType;

        private int tankCapacity;

        private double gasolineConsume;

        public Motocycle(double base_price,String mark,int model, Double cilinderCapacity, int kilometers, VehicleType type, String licensePlate, Documents [] documents,MotocycleType motoType, int tankCapacity){

            super(base_price, mark, model, cilinderCapacity, kilometers, type, licensePlate, documents );
            this.tankCapacity= tankCapacity;
            this.motoType = motoType;

        }

        @Override
        public double calculateSellPrice() {
            
            double cost = base_price;

            double more = base_price*0.04;

            cost += more;

            if(documents[1] == null || documents[2] == null || documents[1].getYear()<2022 || documents[2].getYear()<2022){
                cost += 500000;
            }
            
            if(type == VehicleType.USED){
                double discont = base_price*0.02;
                cost -= discont;
            }

            return cost;
        }

        @Override
        public double gasolineConsume() {
            double out =  0;

            out = tankCapacity*(cilinderCapacity/75);

            return out;
        }

        @Override
        public String toString(){
            return "MOTOCYCLE \n " + super.toString() +
            "Moto type : " +  motoType + "\n" + 
            "Tank capacity : " + tankCapacity +"\n" +
            "Gasoline consume :" + gasolineConsume() + "\n" +
            "Sell price : " + calculateSellPrice();
        }
    }
    