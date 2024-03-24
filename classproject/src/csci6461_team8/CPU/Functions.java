package CPU;


////////////////////////////////////////////////////////////////////////     PROGRAM COUNTER     /////////////////////////////////////////////////////////////////////

public class ProgramCounter {
	//initializes the PC to 0
	private int PCaddress = 0;

	public ProgramCounter(){
	}

	//initial the PC address if appropriate
	public ProgramCounter(int PCaddress){
		if (PCaddress < Math.pow(2,12) && PCaddress >= 0){
			this.PCaddress = PCaddress;
		}
	}

	//increments the PC
	public void PCPlus(){
		PCaddress++;
	}

	//gets the PC address
	public int getPCaddress(){
		return PCaddress;
	}

	//re-assigns the PC address if required and fits the appropriate range of the machine
	public boolean setPCaddress(int newaddress){
		if (newaddress < Math.pow(2,12) && newaddress >= 0){
			PCaddress = newaddress;
			return true;
		}
		else
			return false;
	}
}



//////////////////////////////////////////////////////////////   BINARY TO DECIMAL   ///////////////////////////////////////////////////////////

public class ConvertBinToDec {
	public static int convertbintodec(String bin_number) {
		int decimal=Integer.parseInt(bin_number,2);
		return decimal;
	}  
}


///////////////////////////////////////////////////////////    DECIMAL  TO  BINARY   //////////////////////////////////////////////////////////


public class ConvertDecToBin {
public static String convertDecToBin(int number) {
	return Integer.toBinaryString(number);
}
}


/////////////////////////////////////////////////////////     HEX   TO    DECIMAL    ///////////////////////////////////////////////////////////

public class ConvertHexToDec {
	public static int convertHexToDec(String hex_number) {
		int decimal=Integer.parseInt(hex_number,16); 
		//System.out.println(Integer.parseInt("ffff",16));
		return decimal;
	} 
	
	public static void main(String args[]) {
		System.out.println(Integer.parseInt("ffff",16));
	}
}
