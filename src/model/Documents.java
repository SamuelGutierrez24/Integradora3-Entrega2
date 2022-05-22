package model;

public abstract class Documents {
    
    private double price;

    private int year;

    protected static final int IMAGE = 4;

    protected int [][] image;

    public Documents(double price,int year){

        this.price = price;
        this.year = year;
        image = new int [IMAGE][IMAGE];

        for(int i = 0;i<IMAGE;i++){
            for(int count = 0;count<IMAGE;count++){
                int sumama= (int)(Math.random()*(100)-1);
                image[i][count] = sumama;
                
            }
        }

    }

    public abstract String decodification();

    public int getYear() {
        return year;
    }

    public double getPrice(){
        return price;
    }

    public String toString(){
        return "Price : " + price +
        "\n Year : " + year +
        "\n Image : \n" + printNumeric()+ "\n" + "decodification: " + decodification();
    }
    public abstract String printNumeric();
}
