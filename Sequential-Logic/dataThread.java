import java.util.Random;

public class dataThread extends Thread {

	private Random rand = new Random();
	public static int data = 0;
	private boolean when = true;

	public void run() {
		while (when) {

			int rnd = rand.nextInt(2);
			data = rnd;

		}
		when = true;
	}

	public void end() {
		this.when = false;
	}
}
