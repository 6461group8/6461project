package CPU;

import string_utility;

public class registers {

    // Condition Code: set when arithmetic/logical operations are executed 4 bits
    int cc;
    
    // General Purpose Register gpr0 16 bits
    int gpr0;
    
    // General Purpose Register gpr1 16 bits
    int gpr1;
    
    // General Purose Register gpr2 16 bits
    int gpr2;
    
    // General Purpose Register R3 16 bits
    int gpr3;
    
    // Instruction Register: holds the instruction to be executed 16 bits
    int ir;
    
    // Memory Address Register: holds the address of the word to be fetched from memory 16 bits
    int mar;
    
    // Memory Buffer Register: holds the word just fetched from or the word to be last stored into memory 16 bits
    int mbr;

    
    // Machine Fault Register: contains the ID code if a machine fault after it
    // occurs.<br/>
    // 4 bits.<br/>
    // 0 - Illegal Memory Address to Reserved Locations;<br/>
    // 1 - Illegal TRAP code;<br/>
    // 2 - Illegal Operation Code;<br/>
    // 3 - Illegal Memory Address beyond 2048 (memory installed).
    int mfr;

    // Machine Status Register: certain bits record the status of the health of
    // the machine.<br/>
    // 16 bits.
    int msr;

    
    // Program Counter: address of next instruction to be executed 12 bits
    int pc;

    // Index Register ixr1 16 bits.
    int ixr1;
    
    // Index Register X2 16 bits.
    int ixr2;
    
    //Index Register ixr3 16 bits
    int ixr3;

    // floating point register 16 bits
    int fr0;

    public void setFr0(int fr0) {
        this.fr0 = fr0;
    }

    public void setFr1(int fr1) {
        this.fr1 = fr1;
    }

    // floating point register 16 bits
    int fr1;

    // initialize all the registers
    public registers() {
        this.cc = 0;
        this.ir = 0;
        this.mar = 0;
        this.mbr = 0;
        this.mfr = 0;
        this.msr = 0;
        this.pc = 0;
        this.gpr0 = 0;
        this.gpr1 = 0;
        this.gpr2 = 0;
        this.gpr3 = 0;
        this.ixr1 = 0;
        this.ixr2 = 0;
        this.ixr3 = 0;
    }

    // reset all the registers

    public void init() {
        this.cc = 0;
        this.ir = 0;
        this.mar = 0;
        this.mbr = 0;
        this.mfr = 0;
        this.msr = 0;
        this.pc = 0;
        this.gpr0 = 0;
        this.gpr1 = 0;
        this.gpr2 = 0;
        this.gpr3 = 0;
        this.ixr1 = 0;
        this.ixr2 = 0;
        this.ixr3 = 0;
    }

    public int getCC() {
        return cc;
    }

    public void setCC(int cc) {
        this.cc = cc;
    }

     // @param bitNum
     //           </br>
     //           0 - OVERFLOW</br>
     //           1 - UNDERFLOW</br>
     //           2 - DIVZERO</br>
     //           3 - EQUALORNOT
     // @return
    
    public boolean getCCElementByBit(int bitNum) {
        return ((this.cc & (1 << bitNum)) != 0);
    }

     // @param bitNum
     //           </br>
     //           0 - OVERFLOW</br>
     //           1 - UNDERFLOW</br>
     //           2 - DIVZERO</br>
     //           3 - EQUALORNOT
     // @param flag
     //            set either 1 or 0
    
    public void setCCElementByBit(int bitNum, boolean flag) {
        if (flag) {
            this.cc = (this.cc | (1 << bitNum));
        } else {
            int mask = ~(1 << bitNum);
            this.cc = this.cc & mask;
        }
    }

    public int getGPR0() {
        return gpr0;
    }

    public void setGPR0(int gpr0) {
        this.gpr0 = gpr0;
    }

    public int getGPR1() {
        return gpr1;
    }

    public void setGPR1(int gpr1) {
        this.gpr1 = gpr1;
    }

    public int getGPR2() {
        return gpr2;
    }

    public void setGPR2(int gpr2) {
        this.gpr2 = gpr2;
    }

    public int getGPR3() {
        return gpr3;
    }

    public void setGPR3(int gpr3) {
        this.gpr3 = gpr3;
    }

    // @param num
    //            from 0 to 3
    // @param r
    //            the value of the GPR
    
    public void setRnByNum(int num, int r) {
        if (num == 0)
            this.gpr0 = r;
        if (num == 1)
            this.gpr1 = r;
        if (num == 2)
            this.gpr2 = r;
        if (num == 3)
            this.gpr3 = r;
    }

     //@param num
     //           from 0 to 3
     //@return the value of the GPR
     //
    
    public int getRnByNum(int num) {
        if (num == 0)
            return this.gpr0;
        if (num == 1)
            return this.gpr1;
        if (num == 2)
            return this.gpr2;
        if (num == 3)
            return this.gpr3;
        return 0;
    }

    public int getIR() {
        return ir;
    }

    // @return the value of IR in 16 bit binary String

    public String getBinaryStringIr() {
        if (this.ir <= 0xffff) {
            return String.format("%16s", Integer.toBinaryString(this.ir)).replace(" ", "0");
        }
        return null;
    }

    public void setIR(int ir) {
        this.ir = ir;
    }

    public int getMAR() {
        return mar;
    }

    public void setMAR(int mar) {
        this.mar = mar;
    }

    public int getMBR() {
        return mbr;
    }

    public void setMBR(int mbr) {
        this.mbr = mbr;
    }

    public int getMFR() {
        return mfr;
    }

    public void setMFR(int mfr) {
        this.mfr = mfr;
    }

    public int getMSR() {
        return msr;
    }

    public void setMSR(int msr) {
        this.msr = msr;
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void increasePCByOne() {
        this.pc++;
    }

    public int getIXR1() {
        return ixr1;
    }

    public void setIXR1(int ixr1) {
        this.ixr1 = ixr1;
    }

    public int getIXR2() {
        return ixr2;
    }

    public void setIXR2(int ixr2) {
        this.ixr2 = ixr2;
    }

    public int getIXR3() {
        return ixr3;
    }

    public void setIXR3(int ixr3) {
        this.ixr3 = ixr3;
    }
    
    public int getFR0(){
    	return fr0;
    }
    
    public void setFR0(int fr0) {
    	this.fr0=fr0;
    }
    
    public int getFR1() {
    	return fr1;
    }
    
    public void setFR1(int fr1) {
    	this.fr1=fr1;
    }
    
    /**
     * @param num
     *            from 1 to 3
     * @return the value of Index Register
     */
    public int getXnByNum(int num) {
        if (num == 1)
            return this.ixr1;
        if (num == 2)
            return this.ixr2;
        if (num == 3)
            return this.ixr3;
        return 0;
    }

     // @param num
     //            from 1 to 3
     // @param x
     //            the value of Index Register
    
    public void setXnByNum(int num, int x) {
        if (num == 1)
            this.ixr1 = x;
        if (num == 2)
            this.ixr2 = x;
        if (num == 3)
            this.ixr3 = x;

    }
    public int getFRByNum(int num){
    	if(num==0){
    		return this.fr0;
    	}
    	if(num==1){
    		return this.fr1;
    	}
    	return 0;
    }
    
    public void setFRByNum(int num, int fr){
    	if (num==0){
    		this.fr0=fr;
    	}
    	if (num==1){
    		this.fr1=fr;
    	}
    }
    
    String exp="0000000";
    String man="00000000";
    String output=null;
    public int getConvertFRByNum(int num) {
        if (num == 0){
        	String fr0s=Integer.toBinaryString(fr0);
        	int len=fr0s.length();
        	int expI;
        	int manI;
        	
        	if(len==16){
        	exp=fr0s.substring(1, 8);
        	man=fr0s.substring(8, 16);
        	expI=Integer.parseInt(exp,2);
    		man=man.substring(0, expI);
    		char[] ori=man.toCharArray();
    		for(int i=expI-1; i>=0; i--){
    		   
    			if(ori[i]=='1'){
    				ori[i]='0';
    				break;
    			}else{
    				ori[i]='1';
    				continue;
    			}
    		
    		}
    		for( int k=0; k<=expI-1; k++){
    			if(ori[k]=='1'){
    				ori[k]='0';
    				
    			}else{
    				ori[k]='1';
    				
    			}
    		}
    		man=new String(ori);
    		manI=Integer.parseInt(man,2);
    		fr0=-1*manI;
        	}else{
        	
        	
        		exp=fr0s.substring(0, len-8);
        		man=fr0s.substring(len-8);
        	
        		expI=Integer.parseInt(exp,2);
        		manI=Integer.parseInt(man.substring(0, expI),2);
        		fr0=manI;
        
        	}	
        	
            return this.fr0;
        }
        if (num == 1){
        	String fr1s=Integer.toBinaryString(fr1);
        	int len=fr1s.length();
        	int expI;
        	int manI;
        	
        	if(len==16){
        	exp=fr1s.substring(1, 8);
        	man=fr1s.substring(8, 16);
        	expI=Integer.parseInt(exp,2);
    		man=man.substring(0, expI);
    		char[] ori=man.toCharArray();
    		for(int i=expI-1; i>=0; i--){
    		   
    			if(ori[i]=='1'){
    				ori[i]='0';
    				break;
    			}else{
    				ori[i]='1';
    				continue;
    			}
    		
    		}
    		for( int k=0; k<=expI-1; k++){
    			if(ori[k]=='1'){
    				ori[k]='0';
    				
    			}else{
    				ori[k]='1';
    				
    			}
    		}
    		man=new String(ori);
    		manI=Integer.parseInt(man,2);
    		fr1=-1*manI;
        	}else{
        	
        	
        		exp=fr1s.substring(0, len-8);
        		man=fr1s.substring(len-8);
        	
        		expI=Integer.parseInt(exp,2);
        		manI=Integer.parseInt(man.substring(0, expI),2);
        		fr1=manI;
        
        	}	
            return this.fr1;
        }
        return 0;
    }

    public void setConvertFRByNum(int num, int fr) {
    	String input=null;
    	
    	if(num==0){
    		if(fr>=0){
    			input = Integer.toBinaryString(fr);
    			man=input+man.substring(input.length());
    			String temp=Integer.toBinaryString(input.length());
    			exp=exp.substring(0, 7-temp.length())+temp;
    			output="0"+exp+man;
        	
    		}else{
        	fr=-1*fr;
        	input=Integer.toBinaryString(fr);
        	
        	char[] opp=input.toCharArray();
        	int k;
        	for(int i=0; i<input.length();i++){
        		
        		if (opp[i]=='0'){
        			opp[i]='1';
        		}else{
        			opp[i]='0';
        		}
        		
        	}
        	for(k=input.length()-1;k>=0;k--){
        	if(opp[k]=='0'){
        		opp[k]='1';
        		break;
        	}else {
        		opp[k]='0';
        		continue;
        	}
        	}	
        	String valid=new String(opp);	
        	man=valid+man.substring(input.length());
        	
        	String temp=Integer.toBinaryString(input.length());
        	exp=exp.substring(0, 7-temp.length())+temp;
        	output="1"+exp+man;
        }
        	this.fr0 = Integer.parseInt(output,2);
        }
        if (num == 1){
        	if(fr>=0){
                input = Integer.toBinaryString(fr);
            	man=input+man.substring(input.length());
            	String temp=Integer.toBinaryString(input.length());
            	exp=exp.substring(0, 7-temp.length())+temp;
            	output="0"+exp+man;
            	
            }else{
            	fr=-1*fr;
            	input=Integer.toBinaryString(fr);
            	
            	char[] opp=input.toCharArray();
            	int k;
            	for(int i=0; i<input.length();i++){
            		
            		if (opp[i]=='0'){
            			opp[i]='1';
            		}else{
            			opp[i]='0';
            		}
            		
            	}
            	for(k=input.length()-1;k>=0;k--){
            	if(opp[k]=='0'){
            		opp[k]='1';
            		break;
            	}else {
            		opp[k]='0';
            		continue;
            	}
            	}	
            	String valid=new String(opp);	
            	man=valid+man.substring(input.length());
            	
            	String temp=Integer.toBinaryString(input.length());
            	exp=exp.substring(0, 7-temp.length())+temp;
            	output="1"+exp+man;
            }
            this.fr1 = Integer.parseInt(output,2);
        }
    }

    public int getRegistersByName(String name) {
        if (name.equals("CC"))
            return this.cc;
        if (name.equals("GPR0"))
            return this.gpr0;
        if (name.equals("GPR1"))
            return this.gpr1;
        if (name.equals("GPR2"))
            return this.gpr2;
        if (name.equals("GPR3"))
            return this.gpr3;
        if (name.equals("IR"))
            return this.ir;
        if (name.equals("MAR"))
            return this.mar;
        if (name.equals("MBR"))
            return this.mbr;
        if (name.equals("MFR"))
            return this.mfr;
        if (name.equals("MSR"))
            return this.msr;
        if (name.equals("PC"))
            return this.pc;
        if (name.equals("IXR1"))
            return this.ixr1;
        if (name.equals("IXR2"))
            return this.ixr2;
        if (name.equals("IXR3"))
            return this.ixr3;
        if (name.equals("FR0"))
            return this.fr0;
        if (name.equals("FR1"))
            return this.fr1;
        return 0;
    }

    public int getBitLongByName(String name) {
        if (name.equals("CC"))
            return 4;
        if (name.equals("R0"))
            return 16;
        if (name.equals("R1"))
            return 16;
        if (name.equals("R2"))
            return 16;
        if (name.equals("R3"))
            return 16;
        if (name.equals("IR"))
            return 16;
        if (name.equals("MAR"))
            return 16;
        if (name.equals("MBR"))
            return 16;
        if (name.equals("MFR"))
            return 4;
        if (name.equals("MSR"))
            return 16;
        if (name.equals("PC"))
            return 12;
        if (name.equals("IXR1"))
            return 16;
        if (name.equals("IXR2"))
            return 16;
        if (name.equals("IXR3"))
            return 16;
        if (name.equals("FR0"))
            return 16;
        if (name.equals("FR1"))
            return 16;
        return 0;
    }

}
