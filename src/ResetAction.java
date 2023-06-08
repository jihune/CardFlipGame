import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetAction implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		// 시작 버튼 카운트다운 중이 아닐 때, 카드 뒤집고 틀려서 딜레이 쓰레드가 돌지 않을 때
		if (StartAction.threadState == false && CardPanel.flipDelayThState == false) {
			StartAction.buttonClicked = false;
			
			GameWindow.cardLeng = GameWindow.originCardLeng;
			
			GameWindow.level = 1;
			GameWindow.levelLabel.setText("레벨 => "+ GameWindow.level);
			
			GameWindow.life = 3;
			GameWindow.lifeLabel.setText("목숨 => "+ GameWindow.life +"개");
			
			GameWindow.cardPane.clearStaticVal();
			GameWindow.contentPane.remove(GameWindow.cardPane.getCardPanel());
			GameWindow.cardPane.cardButtonGen();
			GameWindow.cardPane.cardPanelGen();
			GameWindow.contentPane.add(GameWindow.cardPane.getCardPanel());
			
			// 게임 결과 창 열려있으면
			if (GameResult.ggState == true) {
				GameResult.frame.dispose();
				GameResult.ggState = false;
			}
		}
	}
}