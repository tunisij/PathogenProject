import javax.swing.*;

class GUI {

	PathogenRunner pR = new PathogenRunner();

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JSlider nbrOfDaysSlider;
	JDialog nbrOfDaysDialog;
	JButton enter = new JButton("enter");

	public GUI() {
		nbrOfDaysDialog = new SplashDialog(frame, "test");
		// nbrOfDaysDialog.setSize(300, 200);
		// nbrOfDaysDialog.setLocationRelativeTo(null);
		// nbrOfDaysDialog.setTitle("RunDays");
		// nbrOfDaysDialog.setModal(true);
		// nbrOfDaysDialog.setVisible(true);

		panel.add(enter);

		nbrOfDaysDialog.add(panel);

		// nbrOfDaysSlider = new JSlider(0, pR., 0);

		setupFrame();
	}

	private void setupFrame() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pathogen Simulator 1.0");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}