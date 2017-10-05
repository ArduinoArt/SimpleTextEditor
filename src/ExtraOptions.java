import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExtraOptions extends JPanel{
	private JTextField yourProfit = new JTextField();
	private JLabel yourProfitLabel = new JLabel("Twoja mar¿a");
	public ExtraOptions() {
		setLayout(new GridLayout(1, 1));
		yourProfit.setText("10");
		add(yourProfit);
		add(yourProfitLabel, BorderLayout.CENTER);
	}

}
