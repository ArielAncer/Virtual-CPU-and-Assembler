import java.util.Arrays;

public class RAM4K extends chipClass2 {

	public RAM512[] RAM4K;

	public RAM4K() {
		RAM4K = new RAM512[8];

		for (int i = 0; i < 8; i++) {
			RAM4K[i] = new RAM512();
		}

	}

	public void setRAM4K(int in[], int load, int[] sel) {
		int[] vals = dmux8way(load, Arrays.copyOfRange(sel, 9, 12));
		for (int i = 0; i < 8; i++) {
			RAM4K[i].setRAM512(in, vals[i], Arrays.copyOfRange(sel, 0, 9));
		}

	}

	public int[] getRAM4K(int[] sel) {
		return mux8way16(RAM4K[0].getRAM512(sel), RAM4K[1].getRAM512(sel),
				RAM4K[2].getRAM512(sel), RAM4K[3].getRAM512(sel),
				RAM4K[4].getRAM512(sel), RAM4K[5].getRAM512(sel),
				RAM4K[6].getRAM512(sel), RAM4K[7].getRAM512(sel),
				Arrays.copyOfRange(sel, 9, 12));
	}

	public void printAll() {

		System.out.println("\n\t\t  --=RAM4K=--");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						System.out.println(Arrays
								.toString(RAM4K[l].RAM512[k].RAM64[j].RAM8[i]
										.getRegister()));
					}
				}
			}
		}

	}

}
