import javax.swing.*;

public class CountDownThread extends Thread {
	
	private JTextField countDownText;
	private CardPanel cardPane;
	
	public CountDownThread(JTextField countDown, CardPanel cardPane) {
		this.countDownText = countDown;
		this.cardPane = cardPane;
	}
	
	public void run() {
		StartAction.threadState = true;
		
		countDownText.setText(Integer.toString(5)+"초");
		cardPane.cardButtonSetNum();
		
		for (int i = 4; i >= 0; i--) {
			try {
				Thread.sleep(1000);
				countDownText.setText(Integer.toString(i)+"초");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
		
		countDownText.setText("카운트다운");
		cardPane.cardButtonSetTemp();
		
		StartAction.threadState = false;
	}
}
