import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelUpAction implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		// 레벨업 버튼작동 조건 -> 카드의 총 개수 / 2
		if (CardPanel.successCount == GameWindow.cardLeng && CardPanel.flipDelayThState == false) {
			StartAction.buttonClicked = false;
			
			GameWindow.cardLeng++;
			GameWindow.level++;
			GameWindow.levelLabel.setText("레벨 => "+ GameWindow.level);
			
			GameWindow.life = 3;
			GameWindow.lifeLabel.setText("목숨 => "+ GameWindow.life +"개");
			
			GameWindow.cardPane.clearStaticVal();
			GameWindow.contentPane.remove(GameWindow.cardPane.getCardPanel());
			GameWindow.cardPane.cardButtonGen();
			GameWindow.cardPane.cardPanelGen();
			GameWindow.contentPane.add(GameWindow.cardPane.getCardPanel());
			
			GameResult.frame.dispose();
			GameResult.ggState = false;
		}
	}
}