package model;

public class PropertyCard extends Documents {
    

    public PropertyCard(double price, int year){
        super(price, year);
    }

    @Override
    public String decodification(){
        String out = "";
        for (int i=3; i>= 0; i-- ) { // filas numbers.length
			for (int j = 3; j >= 0; j--) { //columnas numbers[0].length
                if(((i+j)%2) == 0 ){
                    out += image[i][j] + "  ";
                }
			}
			
		}
        return out;
    }

    @Override
    public int getYear() {
        return super.getYear();
    }
    @Override
    public String toString(){
        return "\n\nPROPERTY CARD \n" + super.toString();
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
