import javax.swing.JButton;

public class FlipDelayThread extends Thread {
	
	private JButton[] cardButton;
	private String[] cardText;
	private Integer cardIndex;
	private Boolean[] buttonCount;

	public FlipDelayThread(JButton[] cardButton, String[] cardText, Integer cardIndex, Boolean[] buttonCount) {
		this.cardButton = cardButton;
		this.cardText = cardText;
		this.cardIndex = cardIndex;
		this.buttonCount = buttonCount;
	}

	public void run() {
		CardPanel.flipDelayThState = true;
		
		CardPanel.flipCount = 2;
		
		cardButton[cardIndex].setText(cardText[cardIndex]);
		buttonCount[cardIndex] = true;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		cardButton[cardIndex].setText("");
		cardButton[CardPanel.lastFlipIndex].setText("");
		
		buttonCount[cardIndex] = false;
		buttonCount[CardPanel.lastFlipIndex] = false;
		
		CardPanel.flipCount = 0;
		CardPanel.lastFlipIndex = -1;
		
		CardPanel.flipDelayThState = false;
	}
}
