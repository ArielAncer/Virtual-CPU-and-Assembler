import java.util.Arrays;

public class RAM8 extends chipClass2 {

	public Register[] RAM8;

	public RAM8() {
		RAM8 = new Register[8];
		for (int i = 0; i < 8; i++) {
			RAM8[i] = new Register();
		}

	}

	public int[] getRAM8(int[] sel) {
		return mux8way16(RAM8[0].getRegister(), RAM8[1].getRegister(),
				RAM8[2].getRegister(), RAM8[3].getRegister(),
				RAM8[4].getRegister(), RAM8[5].getRegister(),
				RAM8[6].getRegister(), RAM8[7].getRegister(), sel);
	}

	public void setRAM8(int[] in, int load, int[] sel) {

		int[] vals = dmux8way(load, sel);
		for (int i = 0; i < 8; i++) {
			RAM8[i].setRegister(in, vals[i]);
		}

	}

	public void printAll() {

		System.out.println("\n\t\t  --=RAM8=--");
		for (int i = 0; i < 8; i++) {
			System.out.println(Arrays.toString(RAM8[i].getRegister()));
		}

	}

}
