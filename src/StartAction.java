import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class StartAction implements ActionListener {
	
	private JTextField countDownText;
	private CardPanel cardPane;
	
	static boolean threadState = false;
	static boolean buttonClicked = false;
	
	public StartAction(JTextField countDownText, CardPanel cardPane) {
		this.countDownText = countDownText;
		this.cardPane = cardPane;
	}
	
	public void actionPerformed(ActionEvent e) {		
		if(buttonClicked == false) {	
			buttonClicked = true;

			CountDownThread countDownTh = new CountDownThread(countDownText, cardPane);
			countDownTh.start(); // 끝나면 카드 안보이게 됨
		}	
	}
}