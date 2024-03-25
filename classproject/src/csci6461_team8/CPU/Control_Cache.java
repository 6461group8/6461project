
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.Scanner;

////////////////////////////////////////////////////////////   ASSEMBLER FUNCTIONS   //////////////////////////////////////////////////////////////////////////

public class Assembler {
    private static Map<String, String> mnemonicBinaryOpcodeMapper;

    static{
        mnemonicBinaryOpcodeMapper = new HashMap<>();

        // Miscellaneous Instruction
        mnemonicBinaryOpcodeMapper.put("HLT", "000000");
        //mnemonicBinaryOpcodeMapper.put("", "");

        // Load/Store Instructions
        mnemonicBinaryOpcodeMapper.put("LDR", "000001"); // load register from memory
        mnemonicBinaryOpcodeMapper.put("STR", "000010"); // store register to memory
        mnemonicBinaryOpcodeMapper.put("LDA", "000011"); // load register with address
        mnemonicBinaryOpcodeMapper.put("LDX", "000100"); // load index register from memory
        mnemonicBinaryOpcodeMapper.put("STX", "000101"); // store index register to memory

        // Transfer Instructions
        mnemonicBinaryOpcodeMapper.put("SETCCE", "100100"); // set condition code E
        mnemonicBinaryOpcodeMapper.put("JZ", "000110"); // jump if zero
        mnemonicBinaryOpcodeMapper.put("JNE", "000111"); // jump if not equal
        mnemonicBinaryOpcodeMapper.put("JCC", "001000"); // jump if condition code
        mnemonicBinaryOpcodeMapper.put("JMA", "001001"); // unconditional jump to address
        mnemonicBinaryOpcodeMapper.put("JSR", "001010"); // jump and save return address
        mnemonicBinaryOpcodeMapper.put("RFS", "001011"); // return from subroutine
        mnemonicBinaryOpcodeMapper.put("SOB", "001100"); // subtract one and branch
        mnemonicBinaryOpcodeMapper.put("JGE", "001101"); // jump greater than or equal to

        // Arithmetic and Logical Instruction
        mnemonicBinaryOpcodeMapper.put("AMR", "001110"); // add memory to register
        mnemonicBinaryOpcodeMapper.put("SMR", "001111"); // subtract memory from register
        mnemonicBinaryOpcodeMapper.put("AIR", "010000"); // add immediate to register
        mnemonicBinaryOpcodeMapper.put("SIR", "010001"); // subtract immediate from register
        mnemonicBinaryOpcodeMapper.put("MLT", "010010"); // multiply register by register
        mnemonicBinaryOpcodeMapper.put("DVD", "010011"); // divide register by register
        mnemonicBinaryOpcodeMapper.put("TRR", "010100"); // test the equity of register and register
        mnemonicBinaryOpcodeMapper.put("AND", "010101"); // logical and of register and register
        mnemonicBinaryOpcodeMapper.put("ORR", "010110"); // logical or of register and register
        mnemonicBinaryOpcodeMapper.put("NOT", "010111"); // logical not of register to register
        mnemonicBinaryOpcodeMapper.put("SRC", "011000"); // shift register by count
        mnemonicBinaryOpcodeMapper.put("RRC", "011001"); // rotate register by count

        // I/O Operations
        mnemonicBinaryOpcodeMapper.put("IN", "011010"); // input character to register from device
        mnemonicBinaryOpcodeMapper.put("OUT", "011011"); // output character to device from register
        mnemonicBinaryOpcodeMapper.put("CHK", "011100"); // check device status to register
    }



    public static String binMachineCodeConvertedFromAssembly(String assembly){

        String[] assemblyComponents = assembly.split("[,\\s]+"); // spilt the textual assembly by ' ' and ','
        int assemblyComponentsNum = assemblyComponents.length;
        String mnemonicString = assemblyComponents[0]; // the first component is the mnemonic
        String opcodeBinaryString = mnemonicBinaryOpcodeMapper.get(mnemonicString); // binary form of the mnemonic
        int operationInteger = Integer.parseInt(opcodeBinaryString, 2);

        StringBuilder binaryMachineCodeBuilder;
        switch (operationInteger){
            case 0: // HLT
                return "0000000000000000";

            case 1: // LDR r,x,address[,I] (load register from memory)
                    // Opcode R  IX I Address
                    // 000001 xx xx x xxxxx

            case 2: // STR r,x,address[,I] (store register memory)
                    // Opcode R  IX I Address
                    // 000010 xx xx x xxxxx

            case 3: // LDA r,x,address[,I] (load register with address)
                    // Opcode R  IX I Address
                    // 000011 xx xx x xxxxx

            case 7: // JNE r,x,address[,I] (jump if not equal)
                    // Opcode R  IX I Address
                    // 000111 xx xx x xxxxx

            case 8: // JCC cc,x,address[,I] (jump if condition code)
                    // Opcode cc IX I Address
                    // 001000 xx xx x xxxxx

            case 12: // SOB r,x,address[,I] (subtract one and branch)
                     // Opcode r  IX I Address
                     // 001100 xx xx x xxxxx

            case 13: // SOB r,x,address[,I] (subtract one and branch)
                     // Opcode r  IX I Address
                     // 001101 xx xx x xxxxx

            case 14: // AMR r,x,address[,I] (add memory to register)
                     // Opcode r  IX I Address
                     // 001110 xx xx x xxxxx

            case 15: // SMR r,x,address[,I] (subtract memory from register)
                     // Opcode r  IX I Address
                     // 001111 xx xx x xxxxx

                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(opcodeBinaryString); // append binary opcode
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[1],2)); // append binary general register
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[2],2)); // append binary index register
                if(assemblyComponentsNum == 5){ // I field exists
                    binaryMachineCodeBuilder.append("1");
                } else {
                    binaryMachineCodeBuilder.append("0");
                } // append I
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[3],5)); // append binary address

                return binaryMachineCodeBuilder.toString();

            case 4: // LDX x,address[,I] (load index register from memory)
                    // Opcode R  IX I Address
                    // 000100 00 xx x xxxxx

            case 5: // STX x,address[,I] (store index register to memory)
                    // Opcode R  IX I Address
                    // 000101 00 xx x xxxxx

            case 6: // JZ x,address[,I] (jump if zero)
                    // Opcode R  IX I Address
                    // 000110 00 xx x xxxxx

            case 9: // JMA x,address[,I] (unconditional jump to address)
                    // Opcode R  IX I Address
                    // 001001 00 xx x xxxxx

            case 10: // JSR x,address[,I] (jump and save return address)
                    // Opcode R  IX I Address
                    // 001010 00 xx x xxxxx

                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(opcodeBinaryString); // append binary opcode
                binaryMachineCodeBuilder.append("00"); // no regular register, filled with "00"
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[1],2)); // append binary index register
                if(assemblyComponentsNum == 4){ // I field exists
                    binaryMachineCodeBuilder.append("1");
                } else {
                    binaryMachineCodeBuilder.append("0");
                } // append I
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[2],5)); // append binary address
                return binaryMachineCodeBuilder.toString();

            case 36: // SETCCE r (set the E bit of condition code)
                     // Opcode R  IX I Address
                     // 100100 xx 00 0 00000
                     // 100100 01 00 0 00000

            case 23: // NOT rx (logical Not of register to register)
                     // Opcode Rx Ry ------
                     // 010111 xx 00 000000
                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(opcodeBinaryString); // append binary opcode
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[1],2)); // append binary regular register
                binaryMachineCodeBuilder.append("00000000"); // no IX, I, Address, filled with "00000000"

                return binaryMachineCodeBuilder.toString();

            case 11: // RFS Immed (return from subroutine w/ return code as Immed in instruction's address field)
                     // Opcode R  IX I Address
                     // 001011 11 00 0 xxxxx
                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(opcodeBinaryString); // append binary opcode
                binaryMachineCodeBuilder.append("1100000"); // append regular register, ignored IX and I
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[1],5)); // append binary address
                return binaryMachineCodeBuilder.toString();

            case 16: // AIR r,Immed (add immediate to register)
                     // Opcode R  IX I Address
                     // 010000 xx 00 0 xxxxx

            case 17: // SIR r,Immed
                     // Opcode R  IX I Address
                     // 010001 xx 00 0 xxxxx

            case 26: // IN r,devid (input character to register from device)
                // Opcode R  --- DevID
                // 011010 xx 000 xxxxx

            case 27: // OUT r,devid (ouput character to device from register)
                // Opcode R  --- DevID
                // 011011 xx 000 xxxxx

            case 28: // CHK r,devid (check device status to register)
                // Opcode R  --- DevID
                // 011100 xx 000 xxxxx

                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(opcodeBinaryString); // append binary opcode
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[1],2)); // append binary regular register
                binaryMachineCodeBuilder.append("000"); // ignored IX and I
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[2],5)); // append binary address / device id
                return binaryMachineCodeBuilder.toString();

            case 18: // MLT rx,ry (multiply register by register)
                     // Opcode Rx Ry ------
                     // 010010 xx xx 000000

            case 19: // DVD rx,ry (divide register by register)
                     // Opcode Rx Ry ------
                     // 010011 xx xx 000000

            case 20: // TRR rx,ry (test the equity of register and register)
                     // Opcode Rx Ry ------
                     // 010100 xx xx 000000

            case 21: // AND rx,ry (logical And of register and register)
                     // Opcode Rx Ry ------
                     // 010101 xx xx 000000

            case 22: // ORR rx,ry (logical Or of register and register)
                     // Opcode Rx Ry ------
                     // 010110 xx xx 000000
                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(opcodeBinaryString); // append binary opcode
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[1],2)); // append binary Rx
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[2],2)); // append binary Ry
                binaryMachineCodeBuilder.append("000000");

                return binaryMachineCodeBuilder.toString();

            case 24: // SRC r,count,L/R,A/L (shift register by count)
                     // Opcode R  A/L L/R -- Count
                     // 011000 xx x   x   00 xxxx

            case 25: // RRC r,count,L/R,A/L (rotate register by count)
                     // Opcode R  A/L L/R -- Count
                     // 011001 xx x   x   00 xxxx

                binaryMachineCodeBuilder = new StringBuilder();
                binaryMachineCodeBuilder.append(opcodeBinaryString); // append binary opcode
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[1],2)); // append binary regular register
                binaryMachineCodeBuilder.append(assemblyComponents[4]); // append A/L
                binaryMachineCodeBuilder.append(assemblyComponents[3]); // append L/R
                binaryMachineCodeBuilder.append("00");
                binaryMachineCodeBuilder.append(PosNotationTools.binStrFromDecStr(assemblyComponents[2],4)); // append binary count

                return binaryMachineCodeBuilder.toString();

        }
        return "";
    }

    public static String octMachineCodeConvertedFromAssembly(String assembly){
        return PosNotationTools.octStrFromBinStr(binMachineCodeConvertedFromAssembly(assembly),6);
    }

    public static void assembly(String assemblySrcFilePath, String listingFilePath, String loadFilePath) throws IOException {
        List<String> assemblyLines = Files.readAllLines(Paths.get(assemblySrcFilePath));
        int assemblyLinesSize = assemblyLines.size();

        try (OutputStream listingFileOutputStream = Files.newOutputStream(Paths.get(listingFilePath));
             OutputStream loadFileOutputStream = Files.newOutputStream(Paths.get(loadFilePath))) {

            int nextInstructionAddress = 0;

            for (int i = 0; i < assemblyLinesSize; i++) {
                int commentStartIdx = assemblyLines.get(i).indexOf(';');
                String instr = assemblyLines.get(i).trim();
                String comment = "";

                if (commentStartIdx != -1) {
                    instr = assemblyLines.get(i).substring(0, commentStartIdx).trim();
                    comment = assemblyLines.get(i).substring(commentStartIdx);
                }

                int mnemonicEndIdx = instr.indexOf(' ');
                String mnemonic = instr.substring(0, mnemonicEndIdx);

                switch (mnemonic) {
                    case "LOC": {
                        nextInstructionAddress = Integer.parseInt(instr.substring(mnemonicEndIdx + 1).trim());
                        String listingLine = "                        " + String.format("%-24s", instr) + comment;
                        listingFileOutputStream.write((listingLine + '\n').getBytes());
                        break;
                    }
                    case "Data": {
                        String octAddressStr = PosNotationTools.octStrFromInteger(nextInstructionAddress, 6);
                        String dataString = instr.substring(mnemonicEndIdx + 1).trim();
                        int data = dataString.equals("End") ? 1024 : Integer.parseInt(dataString);
                        String octDataStr = PosNotationTools.octStrFromInteger(data, 6);

                        String loadLine = String.format("%-12s", octAddressStr) + octDataStr;
                        loadFileOutputStream.write((loadLine + '\n').getBytes());

                        String listingLine = loadLine + "      " + String.format("%-24s", instr) + comment;
                        listingFileOutputStream.write((listingLine + '\n').getBytes());

                        nextInstructionAddress += 1;
                        break;
                    }
                    case "End:": {
                        String octAddressStr = PosNotationTools.octStrFromInteger(nextInstructionAddress, 6);
                        String loadLine = String.format("%-12s", octAddressStr) + "000000";
                        loadFileOutputStream.write((loadLine + '\n').getBytes());

                        String listingLine = loadLine + ' ' + String.format("%-29s", "End: HLT") + comment;
                        listingFileOutputStream.write((listingLine + '\n').getBytes());
                        break;
                    }
                    default: {
                        String octAddressStr = PosNotationTools.octStrFromInteger(nextInstructionAddress, 6);
                        String octInstrMachineCode = octMachineCodeConvertedFromAssembly(instr);
                        String loadLine = String.format("%-12s", octAddressStr) + octInstrMachineCode;
                        loadFileOutputStream.write((loadLine + '\n').getBytes());

                        String listingLine = loadLine + "      " + String.format("%-24s", instr) + comment;
                        listingFileOutputStream.write((listingLine + '\n').getBytes());

                        nextInstructionAddress += 1;
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the path of the assembly source file: ");
        String assembly = scanner.nextLine();
        File assemblyFile = new File(assembly);
        String dir = assemblyFile.getParent();
        if(dir != null){
            dir = dir + '/';
        }
        else{
            dir = "";
        }

        String name = assemblyFile.getName();
        int lastDotIndex = name.lastIndexOf('.');
        name = name.substring(0, lastDotIndex);

        String listing, load;
        listing = dir + name + "listing.txt";
        load = dir + name + "load.txt";

        assembly(assembly,listing,load);

        System.out.println("Build finished.");
    }

}


//////////////////////////////////////////////////////////////////////    MCU   ////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import memory.Cache.CacheLine;
import util.Const;

/**
 * Memory Control Unit<br/>
 * Reserved Locations Of Memory:<br/>
 * 0 - Reserved for the Trap instruction for Part III.<br/>
 * 1 - Reserved for a machine fault<br/>
 * 2 - Store PC for Trap<br/>
 * 3 - NU<br/>
 * 4 - Store PC for Machine Fault<br/>
 * 5 - NU<br/>
 */
public class MCU {

	/**
	 * 16 bit words
	 */
	ArrayList<Integer> memory;

	/**
	 * 16 block fully associative, unified cache
	 */
	Cache cache;

	String printerBuffer;
	String keyboardBuffer;
	String cardBuffer;

	public String getPrinterBuffer() {
		return printerBuffer;
	}

	public void setPrinterBuffer(String printerBuffer) {
		this.printerBuffer = printerBuffer;
	}

	public String getKeyboardBuffer() {
		return keyboardBuffer;
	}

	public void setKeyboardBuffer(String keyboardBuffer) {
		this.keyboardBuffer = keyboardBuffer;
	}

	public String getCardBuffer() {
		return cardBuffer;
	}

	public void setCardBuffer(String cardBuffer) {
		this.cardBuffer = cardBuffer;
	}

	public Cache getCache() {
		return cache;
	}

	/**
	 * initialize the MCU, all memories set to 0, memories size 2048.
	 */
	public MCU() {
		this.memory = new ArrayList<Integer>(Const.MEMORY_WORDS_BOUND);
		for (int i = 0; i < Const.MEMORY_WORDS_BOUND; i++) {
			this.memory.add(0);
		}
		this.cache = new Cache();
		// System.out.println("MCU init with a size of " + this.memory.size());
	}

	/**
	 * expand the memory size to 4096
	 */
	public void expandMemorySize() {
		if (this.memory != null && this.memory.size() > 0) {
			this.memory.ensureCapacity(Const.MEMORY_WORDS_BOUND_EXPANDED);
			for (int currentSize = memory.size(); currentSize < Const.MEMORY_WORDS_BOUND_EXPANDED; currentSize++) {
				this.memory.add(0);
			}
		}
		System.out.println("memory size has been expanded to " + memory.size());
	}

	/**
	 * @return current size of the memory
	 */
	public int getCurrentMemorySize() {
		if (this.memory != null) {
			return this.memory.size();
		}
		return 0;
	}

	/**
	 * 
	 * Using the address to fetch a word directly from memory.
	 * 
	 * @param address
	 * @return a word from memory
	 * 
	 */
	public int fetchFromMemory(int address) {
		return this.memory.get(address);
	}

	/**
	 * 
	 * Store directly into memory using address and value.
	 * 
	 * @param address
	 * @param value
	 */
	public void storeIntoMemory(int address, int value) {
		if (this.memory != null) {
			this.memory.set(address, value);
		}
	}

	/**
	 * 
	 * fetch a word from cache. If the word is not in cache, fetch it from
	 * memory, then store it into cache.
	 * 
	 * @param address
	 * @return
	 */
	public int fetchFromCache(int address) {
		for (CacheLine line : cache.getCacheLines()) { // check every block
														// whether the tag is
														// already exist
			if (address == line.getTag()) {
				return line.getData(); // tag exist, return the data of the
										// block
			}
		}
		// tag not exist
		int value = fetchFromMemory(address);
		cache.add(address, value);
		return value;
	}

	/**
	 * 
	 * store into cache with replacement. Also store into memory simultaneously.
	 * 
	 * @param address
	 * @param value
	 */
	public void storeIntoCache(int address, int value) {
		storeIntoMemory(address, value);
		for (CacheLine line : cache.getCacheLines()) { // check every block the
														// tag is already exist
			if (address == line.getTag()) {
				line.setData(value); // replace the block
				return;
			}
		}
		// tag not exist
		cache.add(address, value);
	}

	/**
	 * Load from ROM and store the instructions after octal 10
	 */
	// public void loadMemoryFromROM() {
	// HashMap<String, Integer> rom = Const.ROM;
	// // System.out.println("read from the ROM");
	// if (rom != null) {
	// for (Map.Entry<String, Integer> entry : rom.entrySet()) {
	// int address = Integer.parseInt(entry.getKey());
	// int value = entry.getValue();
	// storeIntoCache(address, value);
	// }
	// }
	// }

	public void loadProgram(HashMap<String, Integer> program) {
		if (program != null) {
			for (Map.Entry<String, Integer> entry : program.entrySet()) {
				int address = Integer.parseInt(entry.getKey());
				int value = entry.getValue();
				storeIntoCache(address, value);
			}
		}
	}

}



/////////////////////////////////////////////////////////////////////////////////   CACHE   /////////////////////////////////////////////////////////////////



import java.util.LinkedList;

import util.Const;

public class Cache {

	public class CacheLine {

		int tag;
		int data;

		public CacheLine(int tag, int data) {
			this.tag = tag;
			this.data = data;
		}

		public int getTag() {
			return this.tag;
		}

		public void setTag(int tag) {
			this.tag = tag;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}

	LinkedList<CacheLine> cacheLines;

	public Cache() {
		this.cacheLines = new LinkedList<CacheLine>();
	}

	public LinkedList<CacheLine> getCacheLines() {
		return cacheLines;
	}

	public void add(int address, int value) {
		if (this.cacheLines.size() >= Const.CACHE_LINES) {
			this.cacheLines.removeLast();
		}
		this.cacheLines.addFirst(new CacheLine(address, value));
	}

}
