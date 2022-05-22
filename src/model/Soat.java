package model;

public class Soat extends Documents {
    
    private double coverage;

    public Soat(double price, int year, double coverage){
        super(price, year);
        this.coverage = coverage;
    }

    @Override
    public String decodification(){
        
        String out="";
        for (int columna=0; columna< 1; columna++ ) { 
            for (int fila = 0; fila < image.length; fila++) {
                out += image[fila][columna] + " ";
            }
        }
        for(int columna = 1;columna<4;columna++){
            out += image[3][columna] + " ";
        }
        return out;
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

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public String toString(){
        return "\nSOAT \n" + super.toString() + "\n Coverage : " + coverage + "\n";
    }
}

/*String print ="";
for (int i=0; i< numbers.length; i++ ) { // filas numbers.length
    for (int j = 0; j < numbers[0].length; j++) { //columnas numbers[0].length
        print += nubers[i][j] + " ";
    }
    print += "\n";
}
return print;
}*/

