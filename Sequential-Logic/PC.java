import java.util.Arrays;

public class PC extends Thread {

	private chipClass2 chip;
	private int clock;
	private int[] array;
	private boolean when;
	public int[] in;
	public int[] var;

	public PC() {

		chip = new chipClass2();
		array = new int[16];
		in = new int[16];
		var = new int[3];
		when = true;
		clock = 0;

	}

	public void run() {
		System.out.println("\n\t\t  --=PC=--\n");
		while (when) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clock++;
			clock = clock % 2;
			System.out.println(" reset: " + var[0] + " load: " + var[1]
					+ " inc: " + var[2]);
			PCrun(in, var[0], var[1], var[2]);
		}

		when = true;

	}

	public void PCrun(int[] in, int reset, int load, int inc) {

		int[] zero = new int[16];

		array = chip.mux16(array, chip.inc16(array), inc);
		array = chip.mux16(array, in, load);
		array = chip.mux16(array, zero, reset);

		System.out.println(Arrays.toString(array));
	}

	public void end() {
		this.when = false;
	}
}
