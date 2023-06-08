import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CardAction implements ActionListener {
	
	private JButton[] cardButton;
	private String[] cardText;
	private Integer cardIndex;
	private Boolean[] buttonCount;
	
	CardAction(JButton[] cardButton, String[] cardText, int cardIndex, Boolean[] buttonCount) {
        this.cardButton = cardButton;
        this.cardText = cardText;
        this.cardIndex = cardIndex;
        this.buttonCount = buttonCount;
    }
	
	public void actionPerformed(ActionEvent e) {
		// -카드 뒤집을 수 있는 조건-
		// 1. 목숨 1개이상 있을 때, 이미 뒤집혀 있는 카드가 아닐 때
		// 2. 시작 버튼을 누른 상태일 때, 시작 카운트다운 중이 아닐 때
		// 3. 카드 2개를 연속으로 뒤집고 틀려서 플립딜레이 상태가 아닐 때
		if (GameWindow.life > 0 && buttonCount[cardIndex] == false
				&& StartAction.buttonClicked == true && StartAction.threadState == false
				&& CardPanel.flipDelayThState == false) {
			
			// 카드 뒤집혀 있지 않을 때, 카드 1개 뒤집기
			if (CardPanel.flipCount == 0) {
				CardPanel.flipCount = 1;
				CardPanel.lastFlipIndex = cardIndex;
				
				cardButton[cardIndex].setText(cardText[cardIndex]);
				buttonCount[cardIndex] = true;
			}
			// 카드 1장이 뒤집혀 있을 때, 카드 짝을 맞춘경우
			else if (CardPanel.flipCount == 1 && cardText[cardIndex].equals(cardText[CardPanel.lastFlipIndex])) {
				CardPanel.flipCount = 0;
				CardPanel.lastFlipIndex = -1;
				
				cardButton[cardIndex].setText(cardText[cardIndex]);
				buttonCount[cardIndex] = true;
				
				CardPanel.successCount++;
				
				if (CardPanel.successCount == GameWindow.cardLeng) {
					new GameResult();
				}
			}
			// 카드 1장이 뒤집혀 있을 때, 카드 짝을 못 맞춘경우
			else if (CardPanel.flipCount == 1 && !cardText[cardIndex].equals(cardText[CardPanel.lastFlipIndex])) {

				GameWindow.life--;
				GameWindow.lifeLabel.setText("목숨 => "+ GameWindow.life +"개");

				FlipDelayThread flipDelayth = new FlipDelayThread(cardButton, cardText, cardIndex, buttonCount);
				flipDelayth.start();
				
				if (GameWindow.life == 0) {
					new GameResult();
				}
			}
		}
	}
}
