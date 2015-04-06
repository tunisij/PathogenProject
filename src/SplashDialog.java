import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SplashDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private Integer nbrOfDays;

	private JPanel panel = new JPanel();

	private JLabel nbrOfDaysLabel = new JLabel("Number of days to simulate: ");
	private JSpinner nbrSelector = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
	private JButton enterButton = new JButton("Enter");

	public SplashDialog(JFrame parent, String title) {
		super(parent, title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		nbrOfDays = null;

		panel.add(nbrOfDaysLabel);
		panel.add(nbrSelector);
		panel.add(enterButton);
		add(panel);
		
		ButtonListener buttonListener = new ButtonListener();
		enterButton.addActionListener(buttonListener);

		setSize(200, 150);
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public Integer getNbrOfDays(){
		return nbrOfDays;
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			JComponent comp = (JComponent) event.getSource();

			if (comp == enterButton) {
				enterButton();
			}
		}

		private void enterButton() {
			nbrOfDays = (Integer) nbrSelector.getValue();
			dispose();
		}
	}
}
