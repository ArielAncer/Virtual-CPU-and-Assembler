import javax.swing.JOptionPane;

public class memoryTest extends testScript {

	private Register reg;
	private RAM8 ram8;
	private RAM64 ram64;
	private RAM512 ram512;
	private RAM4K ram4k;
	private RAM16K ram16k;
	private chipClass2 chip;

	public memoryTest() {
		reg = new Register();
		ram8 = new RAM8();
		ram64 = new RAM64();
		ram512 = new RAM512();
		ram4k = new RAM4K();
		ram16k = new RAM16K();
		chip = new chipClass2();
	}

	public void chips3() {

		buttonText("Back");
		okButton("OK");

		int choice = 0;
		String str = "";
		dataThread dThread = new dataThread();

		String choiceStr = JOptionPane
				.showInputDialog("Please choose a memory test from the following list by \ninputing it's number:\n\n"
						+ "1. DFF\n2. Bit\n3. Register\n4. RAM8\n5. RAM64\n6. RAM512\n7. RAM4K\n8. RAM16K\n9. PC\n\n");

		if (choiceStr != null) {
			choice = Integer.parseInt(choiceStr);
		}

		switch (choice) {
		case 1:
			okButton("Stop");
			DFF dff = new DFF();
			dThread.start();
			dff.start();

			JOptionPane
					.showMessageDialog(
							null,
							"Please hit the 'Stop' button when you would like the DFF thread to stop running?");
			dff.end();
			dThread.end();

			chips3();
			break;
		case 2:
			okButton("Stop");
			Bit bit = new Bit();
			dThread.start();
			bit.start();

			JOptionPane
					.showMessageDialog(
							null,
							"Please hit the 'Stop' button when you would like the Bit thread to stop running?");
			bit.end();
			dThread.end();

			chips3();
			break;
		case 3:
			str = JOptionPane
					.showInputDialog("1. Create register\n2. View register\n\n");
			switch (Integer.parseInt(str)) {
			case 1:
				reg.setRegister(arr(16), load());
				break;
			case 2:
				reg.printAll();
				break;
			default:
				break;
			}
			chips3();
			break;
		case 4:
			str = JOptionPane
					.showInputDialog("1. Add a register\n2. View registers\n\n");
			switch (Integer.parseInt(str)) {
			case 1:
				ram8.setRAM8(arr(16), load(), arr(3));
				break;
			case 2:
				ram8.printAll();
				break;
			default:
				break;
			}
			chips3();
			break;
		case 5:
			str = JOptionPane
					.showInputDialog("1. Add a register\n2. View registers\n\n");
			switch (Integer.parseInt(str)) {
			case 1:
				ram64.setRAM64(arr(16), load(), arr(6));
				break;
			case 2:
				ram64.printAll();
				break;
			default:
				break;
			}
			chips3();
			break;
		case 6:
			str = JOptionPane
					.showInputDialog("1. Add a register\n2. View registers\n\n");
			switch (Integer.parseInt(str)) {
			case 1:
				ram512.setRAM512(arr(16), load(), arr(9));
				break;
			case 2:
				ram512.printAll();
				break;
			default:
				break;
			}
			chips3();
			break;
		case 7:
			str = JOptionPane
					.showInputDialog("1. Add a register\n2. View registers\n\n");
			switch (Integer.parseInt(str)) {
			case 1:
				ram4k.setRAM4K(arr(16), load(), arr(12));
				break;
			case 2:
				ram4k.printAll();
				break;
			default:
				break;
			}
			chips3();
			break;
		case 8:
			str = JOptionPane
					.showInputDialog("1. Add a register\n2. View registers\n\n");
			switch (Integer.parseInt(str)) {
			case 1:
				ram16k.setRAM16K(arr(16), load(), arr(14));
				break;
			case 2:
				ram16k.printAll();
				break;
			default:
				break;
			}
			chips3();
			break;
		case 9:
			PC pc = new PC();
			dThread.start();
			pc.start();
			PCoptions(pc, dThread);

			chips3();
			break;
		default:
			test();
			break;
		}

	}

	public void PCoptions(PC pc, dataThread dThread) {
		okButton("OK");
		String[] buttons = { "In", "Reset", "Load", "Inc", "Stop" };
		int action = JOptionPane.showOptionDialog(null,
				"Please choose an action for your PC: ", "PC",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				buttons, buttons[4]);
		action++;
		switch (action) {
		case 1:
			pc.in = arr(16);
			PCoptions(pc, dThread);
			break;
		case 2:
			pc.var[0] = chip.not(pc.var[0]);
			PCoptions(pc, dThread);
			break;
		case 3:
			pc.var[1] = chip.not(pc.var[1]);
			PCoptions(pc, dThread);
			break;
		case 4:
			pc.var[2] = chip.not(pc.var[2]);
			PCoptions(pc, dThread);
			break;
		case 5:
			pc.end();
			dThread.end();
			break;
		default:
			break;
		}
	}
}
