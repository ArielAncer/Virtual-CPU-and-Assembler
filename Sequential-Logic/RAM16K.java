import java.util.Arrays;

public class RAM16K extends chipClass2 {

	public RAM4K[] RAM16K;

	public RAM16K() {
		RAM16K = new RAM4K[4];

		for (int i = 0; i < 4; i++) {
			RAM16K[i] = new RAM4K();
		}

	}

	public void setRAM16K(int in[], int load, int[] sel) {
		int[] vals = dmux4way(load, Arrays.copyOfRange(sel, 12, 14));
		for (int i = 0; i < 4; i++) {
			RAM16K[i].setRAM4K(in, vals[i], Arrays.copyOfRange(sel, 0, 12));
		}

	}

	public int[] getRAM16K(int[] sel) {
		return mux4way16(RAM16K[0].getRAM4K(sel), RAM16K[1].getRAM4K(sel),
				RAM16K[2].getRAM4K(sel), RAM16K[3].getRAM4K(sel),
				Arrays.copyOfRange(sel, 12, 14));
	}

	public void printAll() {

		System.out.println("\n\t\t  --=RAM16K=--");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						for (int m = 0; m < 4; m++) {
							System.out
									.println(Arrays
											.toString(RAM16K[m].RAM4K[l].RAM512[k].RAM64[j].RAM8[i]
													.getRegister()));
						}
					}
				}
			}
		}

	}

}
