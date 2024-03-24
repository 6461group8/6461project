package CPU;

///////////////////////////////////////////// GENERAL PURPOSE REGISTERS  /////////////////////////////////////////////////////////////

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

///////////////////////////////////////////// INDEX REGISTERS   ////////////////////////////////////////////////////////


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


///////////////////////////////////////////////////////    INSTRUCTION REGISTER   ////////////////////////////////////////////////////////////////


public class Instruction_Register{
	private int instruction = 0;
	private int opcode = 0;
	private int register = 0;
	private int indexregister = 0;
	private int indirect = 0;
	private int address = 0;

	public Instruction_Register(){
	}

	public boolean setinstruction(int newinstruction){
		// sets all of the appropriate values according to the instruction (part of decode)
		if (newinstruction < Math.pow(2,16) && newinstruction >= 0){
			instruction = newinstruction;
			opcode = instruction / (int) Math.pow(2, 10);
			register = instruction % (int) Math.pow(2, 10) / (int) Math.pow(2, 8);
			indexregister = instruction % (int) Math.pow(2, 8) / (int) Math.pow(2, 6);
			indirect = instruction % (int) Math.pow(2, 6) / (int) Math.pow(2, 5);
			address = instruction % (int) Math.pow(2, 5);
			return true;
		}
		else
			return false;
	}
	
	public int getinstruction(){
		return instruction;
	}

	public int getopcode(){
		return opcode;
	}

	public int getregister(){
		return register;
	}

	public int getindexregister(){
		return indexregister;
	}

	public int getindirect(){
		return indirect;
	}

	public int getaddress(){
		return address;
	}
}


///////////////////////////////////////////////     MEMORY ADDRESS REGISTER    //////////////////////////////////////////////////////////

public class Memory_Address_Register{
	//initializes the MAR
	private int Memaddress = 0;

	public Memory_Address_Register(){
	}
	
	// gets the returns the current address in the MAR
	public int getMemaddress(){
		return Memaddress;
	}

	//Gets the new address, determines if it is appropriate, then sets 
	public boolean setMemaddress(int newaddress){
		if (newaddress < Math.pow(2,12) && newaddress >= 0){
			Memaddress = newaddress;
			return true;
		}
		else
			return false;
	}
}


/////////////////////////////////////////////////    MEMEORY BUFFER REGISTER   ///////////////////////////////////////////////////////

public class Memory_Buffer_Register{
	//initializes the MBR
	private int Data = 0;

	public Memory_Buffer_Register(){
	}

	//gets the returns the data in the MBR
	public int getData(){
		return Data;
	}

	public boolean setData(int newData){
		//checks if the data is appropriate before assigning it to the MBR
		if (newData < Math.pow(2,16) && newData >= 0){
			Data = newData;
			return true;
		}
		else
			return false;
	}
}




/////////////////////////////////////////////////    MEMORY FAULT REGISTER  /////////////////////////////////////////////////////////////


// It now can store the machine Fault 0, 2, 3
// ID	Fault
// 0	Illegal Memory Address to Reserved Locations MFR set to binary 0001
// 1	Illegal TRAP code  MFR set to binary 0010
// 2	Illegal Operation Code MFR set to 0100
// 3	Illegal Memory Address beyond 2048 (memory installed)  MFR set to binary 1000

public class Machine_Fault_Register {
	private int Faultindex = -1;
	
	public Machine_Fault_Register() {
	}
	
	public int getFault() {
		return Faultindex;
	}
	
	public boolean setFault(int Faultindex) {
		if (Faultindex >= 0 && Faultindex < 4) {
			this.Faultindex = Faultindex;
			return true;
		}
		else 
			return false;
	}
	
	public void resetMFR() {
		Faultindex = 0;
	}
}
