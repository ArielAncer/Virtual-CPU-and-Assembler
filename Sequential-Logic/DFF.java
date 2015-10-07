public class DFF extends Thread {

	private int clock = 0;
	private int mem = 0;
	private int dff;
	private boolean when = true;

	public void run() {
		System.out.println("\n\t\t  --=DFF=--\n");
		while (when) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clock++;
			clock = clock % 2;
			dffTest();
		}
		
		when = true;

	}
	
	public void end(){
		this.when = false;	
	}

	public void setDff(int data) {
		int temp = mem;
		mem = data;
		dff = temp;
	}

	public int getDff() {
		return dff;
	}

	public void dffTest() {
		int data = dataThread.data;
		setDff(data);

		System.out.println("Clock: " + clock + " Data: " + data
				+ "        Mem: " + getDff());
	}

}
