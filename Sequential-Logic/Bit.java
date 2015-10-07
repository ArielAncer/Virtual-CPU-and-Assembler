
public class Bit extends Thread {
	
	private int clock = 0;
	private int dffMem = 0;	
    private boolean when = true;
	
	private chipClass2 chip;
	private DFF dff;
	private int bit;
	
	public Bit(){
		chip = new chipClass2();
		dff = new DFF();
	}

	public void run() {
		System.out.println("\n\t\t  --=Bit=--\n");
		while (when) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clock++;
			clock = clock % 2;
			bitTest();
		}
		
		when = true;

	}
	
	public void end(){
		this.when = false;	
	}

 public void setBit(int in, int load){
    dffMem = chip.mux(dffMem, in, load);
    dff.setDff(dffMem);
	bit = dff.getDff();
 }

public int getBit() {
	return bit;
}


public void bitTest(){
	int data = dataThread.data;
	int load = dataThread.data;
	setBit(data,load);
	
	System.out.println("Clock: " + clock + " In: " + data + " Load: " + load + "        Out: " + getBit());
	
}

}
