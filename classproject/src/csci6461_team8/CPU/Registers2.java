package CPU;

public class Index_Registers{
	//initializes the index registers
	private int[] registers = {0, 0, 0};

	public Index_Registers(){
	}

	public Index_Registers(int ixr1, int ixr2, int ixr3){
		// recreate the IXR and determines which register is appropriate and limit the value
		if (ixr1 < Math.pow(2, 12) && ixr1 >= 0)
			registers[0] = ixr1;
		if (ixr2 < Math.pow(2, 12) && ixr2 >= 0)
			registers[1] = ixr2;
		if (ixr3 < Math.pow(2, 12) && ixr3 >= 0)
			registers[2] = ixr3;
	}

	public int getregister(int index){
		if (index >= 1 && index < 4)
			return registers[index - 1];
		// fetches the index if it is between 1 and 3
		else
			return -1;
	}
	
	public boolean setregister(int index, int newvalue) {
		// set the IXRs from GUI
		// limit the index and value
		if (index >= 1 && index < 4) {
			if (newvalue < Math.pow(2, 12) && newvalue >= 0) {
				registers[index - 1] = newvalue;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}

// General Purpose Registers

public class General_Purpose_Registers{
	// defines four General_Purpose_Registers
	private int[] registers = {0, 0, 0, 0};

	public General_Purpose_Registers(){
	}

	public int getregister(int index){
		// checks if the index value is between 0 and 3 and then grabs it, otherwise throws an error
		if (index >= 0 && index < 4)
			return registers[index];
		else
			return -1;
	}

	public boolean setregister(int index, int newvalue){
		// sets the register according to the new value being passed in
		//limit the index and the value
		if (index >= 0 && index < 4){
			if (newvalue < Math.pow(2, 16) && newvalue >= 0){
				registers[index] = newvalue;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}
