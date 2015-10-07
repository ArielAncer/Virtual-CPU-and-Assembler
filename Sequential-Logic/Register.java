import java.util.Arrays;

public class Register extends chipClass2 {

	public int[] register;

	public Register() {

		register = new int[16];

		for (int i = 0; i < 16; i++)

			register[i] = 0;

	}

	public void setRegister(int[] input, int load){

		for (int i = 0; i < 16; i++)
			register[i] = mux(register[i], input[i], load);

	}

	public int[] getRegister(){

		return register;

	}

	public void printAll() {

		System.out.println("\n\t\t  --=Register=--");
		System.out.println(Arrays.toString(register));
	}

}
