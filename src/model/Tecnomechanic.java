package model;

public class Tecnomechanic extends Documents {
    
    private double carGases;

    public Tecnomechanic(double price, int year, double carGases){
        super(price, year);
        this.carGases = carGases;
    }
    @Override
    public String decodification(){
        String out = "";
        for (int i=0; i< 1; i++ ) { // filas numbers.length
			for (int j = 0; j < image[0].length; j++) { //columnas numbers[0].length
				out += image[i][j];
			}
	
		}
        for (int i=1; i< 4; i++ ) { // filas numbers.length
			if(i == 1){
                out += image[i][2];
            }
            if(i==2){
                out += image[i][1];
            }
            if(i == 3){
                for (int j = 0; j < image[0].length; j++) { //columnas numbers[0].length
                    out += image[i][j];
                } 
            }
		}
        
        return out;
    }

    @Override
    public int getYear() {
        return super.getYear();
    }
//...
    @Override
    public String toString(){
        return " \n\n TECNOMECHANIC \n" + super.toString() + "\n Car gases: " + carGases +"\n\n";
    }

    @Override
    public String printNumeric() {
		
        String print ="";
		for (int i=0; i< image.length; i++ ) { // filas numbers.length
			for (int j = 0; j < image[0].length; j++) { //columnas numbers[0].length
				print += image[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}
}
