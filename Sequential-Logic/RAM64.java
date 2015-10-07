import java.util.Arrays;

public class RAM64 extends chipClass2 {

	public RAM8[] RAM64;

	public RAM64() {
		RAM64 = new RAM8[8];

		for (int i = 0; i < 8; i++) {
			RAM64[i] = new RAM8();
		}

	}

	public void setRAM64(int in[], int load, int[] sel) {
		int[] vals = dmux8way(load, Arrays.copyOfRange(sel, 3, 6));
		for (int i = 0; i < 8; i++) {
			RAM64[i].setRAM8(in, vals[i], Arrays.copyOfRange(sel, 0, 3));
		}

	}

	public int[] getRAM64(int[] sel) {
		return mux8way16(RAM64[0].getRAM8(sel), RAM64[1].getRAM8(sel),
				RAM64[2].getRAM8(sel), RAM64[3].getRAM8(sel),
				RAM64[4].getRAM8(sel), RAM64[5].getRAM8(sel),
				RAM64[6].getRAM8(sel), RAM64[7].getRAM8(sel),
				Arrays.copyOfRange(sel, 3, 6));
	}

	public void printAll() {

		System.out.println("\n\t\t  --=RAM64=--");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.println(Arrays.toString(RAM64[j].RAM8[i]
						.getRegister()));
			}
		}

	}

}
