/*
@author Ariel Ancer 
@date 2/15/2014
Assignment 2 - Building chips.
 */

import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class testScript extends chipClass {
	
	/**
	 * Input variables for testing of gates.
	 * 
	 * @return the single integer variable.
	 */
	public int in() {
		String input = JOptionPane
				.showInputDialog("Please enter a single input here:");	
		back(input);
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
		back(sel);
		return Integer.parseInt(sel);
	}
	
	/**
	 * Load variable for testing of gates.
	 * 
	 * @return the single integer load variable.
	 */

	public int load() {
		String load = JOptionPane
				.showInputDialog("Please enter a single load variable here:");
		back(load);
		return Integer.parseInt(load);
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
		
		back(val);

		String[] vals = val.split(",");
		for (int i = 0; i < vals.length; i++) {
			array[i] = Integer.parseInt(vals[i]);
		}

		return array;
	}
	
	/**
	 * This method allows the developer to fashion the user interface by
	 * changing the 'cancel' button's text.
	 * 
	 * @param str the string that the default 'cancel' button is set to.
	 */
	
	public void buttonText(String str){

		UIManager.put("OptionPane.cancelButtonText", str);
	}
	
	public void okButton(String str){

		UIManager.put("OptionPane.okButtonText", str);
	}
	
	
	/**
	 * The back method takes the user back to the main menu if he clicks 
	 * the 'Back' button or submits an empty string.
	 * 
	 * @param input the users input as a string.
	 */
	
	public void back(String input){
		if (input == null || input.equals("")) { 
			test();
			System.exit(0);
			}
	}
	
	/**
	 * The assignment selection menu for testing that directs the user
	 * to the specific assignment's gate testing.
	 */
	
	public void test() {
		buttonText("Exit");
		
		int choice = 0;
		
		String choiceStr = JOptionPane
				.showInputDialog("Please choose a listing of gates from the following menu by \ninputing it's number:\n\n"
						+ "1. Assignment 1 gates\n2. Assingment 2 gates\n3. Assingment 3 memory tests\n\n");
		
		
		if(choiceStr != null){
			choice = Integer.parseInt(choiceStr);
		}
		
		switch (choice) {
		case 1:
			chips1();
			break;
		case 2:
			chips2();
			break;
		case 3:
			memoryTest mem = new memoryTest();
			mem.chips3();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Thank you for using our testing system.\n Have a great day!");
			break;
		}

	}

	/**
	 * The gate selection menu for testing that calls upon the gates within the
	 * chipClass class for assignment 1 gates.
	 */
	
	public void chips1() {
		
		buttonText("Back");
		int choice = 0;
		
		String choiceStr = JOptionPane
				.showInputDialog("Please choose a gate from the following list by \ninputing it's number:\n\n"
						+ "1. Not\n2. And\n3. Or\n4. Xor\n5. Mux\n6. DMux\n7. Not16\n8. And16"
						+ "\n9. Or16\n10. Mux16\n11. Or8Way\n12. Mux4Way16\n13. Mux8Way16\n14. DMux4Way\n15. DMux8Way\n\n");
		
		if(choiceStr != null){
			choice = Integer.parseInt(choiceStr);
		}

		switch (choice) {
		case 1:
			JOptionPane.showMessageDialog(null, not(in()));
			chips1();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, and(in(), in()));
			chips1();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, or(in(), in()));
			chips1();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, xor(in(), in()));
			chips1();
			break;
		case 5:
			JOptionPane.showMessageDialog(null, mux(in(), in(), sel()));
			chips1();
			break;
		case 6:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(dmux(in(), sel())));
			chips1();
			break;
		case 7:
			JOptionPane
					.showMessageDialog(null, Arrays.toString(not16(arr(16))));
			chips1();
			break;
		case 8:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(and16(arr(16), arr(16))));
			chips1();
			break;
		case 9:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(or16(arr(16), arr(16))));
			chips1();
			break;
		case 10:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(mux16(arr(16), arr(16), sel())));
			chips1();
			break;
		case 11:
			JOptionPane.showMessageDialog(null, or8way(arr(8)));
			chips1();
			break;
		case 12:
			JOptionPane.showMessageDialog(null, Arrays.toString(mux4way16(
					arr(16), arr(16), arr(16), arr(16), arr(2))));
			chips1();
			break;
		case 13:
			JOptionPane.showMessageDialog(null, Arrays.toString(mux8way16(
					arr(16), arr(16), arr(16), arr(16), arr(16), arr(16),
					arr(16), arr(16), arr(3))));
			chips1();
			break;
		case 14:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(dmux4way(in(), arr(2))));
			chips1();
			break;
		case 15:
			JOptionPane.showMessageDialog(null,
					Arrays.toString(dmux8way(in(), arr(3))));
			chips1();
			break;
		default:
			test();
			break;
		}

	}
	
	/**
	 * The gate selection menu for testing that calls upon the gates within the
	 * chipClass class for assignment 2 gates.
	 */

	public void chips2() {
		
		buttonText("Back");	
		int choice = 0;
		
		chipClass2 c = new chipClass2();
		
		String choiceStr = JOptionPane
				.showInputDialog("Please choose a gate from the following list by \ninputing it's number:\n\n"
						+ "1. HalfAdder\n2. FullAdder\n3. Add16\n4. Inc16\n5. ALU\n\n");

		if(choiceStr != null){
			choice = Integer.parseInt(choiceStr);
		}

		switch (choice) {
		case 1:
			JOptionPane.showMessageDialog(null, Arrays.toString(c.halfAdder(in(),in())));
			chips2();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, Arrays.toString(c.fullAdder(in(), in(),in())));
			chips2();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, Arrays.toString(c.add16(arr(16), arr(16))));
			chips2();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, Arrays.toString(c.inc16(arr(16))));
			chips2();
			break;
		case 5:
			int[] array = c.alu(arr(16),arr(16),in(), in(),in(), in(),in(), in()).clone();
			int[] arr = Arrays.copyOfRange(array,0,15);
			JOptionPane.showMessageDialog(null, Arrays.toString(arr) + " Zr ="+ array[16] + " Ng =" + array[17]);
			chips2();
			break;
		default:
			test();
			break;
		}

	}
	

}
