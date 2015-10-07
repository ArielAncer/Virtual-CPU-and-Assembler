/*
@author Ariel Ancer 
@date 1/28/2014
Assignment 1 - Building chips.
 */

import java.util.Arrays;

import javax.swing.JOptionPane;

public class testScript extends chipClass {

	/**
	 * Input variables for testing of gates.
	 * 
	 * @return the single integer variable.
	 */
	public int in() {
		String input = JOptionPane
				.showInputDialog("Please enter a single input here:");
		return Integer.parseInt(input);
	}

	/**
	 * Selection variable for testing of gates.
	 * 
	 * @return the single integer selection variable.
	 */

	public int sel() {
		String sel = JOptionPane
				.showInputDialog("Please enter selection variable here:");
		return Integer.parseInt(sel);
	}

	/**
	 * Creates an array from the user's input of 1's and 0's separated by commas.
	 * 
	 * @param num size of the array to be created.
	 * @return the array entered in.
	 */
	
	public int[] arr(int num) {
		int[] array = new int[num];

		String val = JOptionPane.showInputDialog("Enter array of size " + num
				+ " seperated by commas here:\n e.g \" "
				+ Arrays.toString(array).substring(1, (num * 3) - 1) + " \"");

		String[] vals = val.split(",");
		for (int i = 0; i < vals.length; i++) {
			array[i] = Integer.parseInt(vals[i]);
		}
		return array;
	}

	/**
	 * The gate selection menu for testing that calls upon the gates within the
	 * chipClass class.
	 */
	
	public void test() {
		String choiceStr = JOptionPane
				.showInputDialog("Please choose a gate from the following list by \ninputing it's number:\n\n"
						+ "1. Not\n2. And\n3. Or\n4. Xor\n5. Mux\n6. DMux\n7. Not16\n8. And16"
						+ "\n9. Or16\n10. Mux16\n11. Or8Way\n12. Mux4Way16\n13. Mux8Way16\n14. DMux4Way\n15. DMux8Way\n16. Exit\n\n");
		int choice = Integer.parseInt(choiceStr);

		switch (choice) {
		case 1:
			JOptionPane.showMessageDialog(null, not(in()));
			test();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, and(in(), in()));
			test();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, or(in(), in()));
			test();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, xor(in(), in()));
			test();
			break;
		case 5:
			JOptionPane.showMessageDialog(null, mux(in(), in(), sel()));
			test();
			break;
		case 6:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(dmux(in(), sel())));
			test();
			break;
		case 7:
			JOptionPane
					.showMessageDialog(null, Arrays.toString(not16(arr(16))));
			test();
			break;
		case 8:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(and16(arr(16), arr(16))));
			test();
			break;
		case 9:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(or16(arr(16), arr(16))));
			test();
			break;
		case 10:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(mux16(arr(16), arr(16), sel())));
			test();
			break;
		case 11:
			JOptionPane.showMessageDialog(null, or8way(arr(8)));
			test();
			break;
		case 12:
			JOptionPane.showMessageDialog(null, Arrays.toString(mux4way16(
					arr(16), arr(16), arr(16), arr(16), arr(2))));
			test();
			break;
		case 13:
			JOptionPane.showMessageDialog(null, Arrays.toString(mux8way16(
					arr(16), arr(16), arr(16), arr(16), arr(16), arr(16),
					arr(16), arr(16), arr(3))));
			test();
			break;
		case 14:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(dmux4way(in(), arr(2))));
			test();
			break;
		case 15:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(dmux8way(in(), arr(3))));
			test();
			break;
		case 16:
			JOptionPane
					.showMessageDialog(null,
							"Thank you for using our testing system.\n Have a great day!");
			break;
		}

	}
}
