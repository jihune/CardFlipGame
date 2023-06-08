import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CardPanel {
	
	private int cardLeng;
	
	private JPanel cardPane;
	private JButton cardButton[];
	private String cardText[];
	
	static int lastFlipIndex = -1;
    static int flipCount = 0;
    static int successCount = 0;
    static boolean flipDelayThState = false;
	
	CardPanel() {
		clearStaticVal();
	}
	
	public void clearStaticVal() {
		cardLeng = GameWindow.cardLeng;
		
		lastFlipIndex = -1;
		flipCount = 0;
		successCount = 0;
		flipDelayThState = false;
	}
	
	public void cardButtonGen() {
		// -랜덤 카드내용 생성-
	    RandomCard ranCard = new RandomCard();
	    ranCard.makeRandomCard(cardLeng);
	    
	    String cardText1[] = ranCard.getFirstCardList(); // 랜덤카드 배열1 생성
	    String cardText2[] = ranCard.getSecondCardList(); // 배열1 복사후 셔플한 배열2 생성
	    this.cardText = new String[cardLeng * 2];
	    
	    for (int i = 0; i < cardLeng; i++) {
	    	cardText[i] = cardText1[i];
	    	cardText[i + cardLeng] = cardText2[i];
	    }
	    
	    // -카드 버튼 생성-
	    this.cardButton = new JButton[cardLeng * 2];
	    
	    // -카드 버튼의 기능 생성-
	    CardAction cardAc[] = new CardAction[cardLeng *2];
	    Boolean buttonCount[] = new Boolean[cardLeng * 2];
		
	    // -카드 버튼 및 기능 추가- 
	    for (int i = 0; i < cardLeng * 2; i++) {
	    	cardButton[i] = new JButton();
	    	cardButton[i].setFont(new Font("고딕", Font.ITALIC, 20));
	    	buttonCount[i] = false;
	    	cardAc[i] = new CardAction(cardButton, cardText, i, buttonCount);
	    	cardButton[i].addActionListener(cardAc[i]);
	    }
	}
	
	public JPanel getCardPanel() {
		return cardPane;
	}
	
	public void cardPanelGen() {
		this.cardPane = new JPanel();
	    cardPane.setLayout(new GridLayout(2, cardLeng)); // 카드패널 레이아웃 설정 2*6
		
	    for (int i = 0; i < cardLeng * 2; i++) {
	    	cardPane.add(this.cardButton[i]);
	    }
	}
	
	public void cardButtonSetNum() {
		for (int i = 0; i < cardLeng * 2; i++) {
			cardButton[i].setText(cardText[i]);
	    }
	}
	
	public void cardButtonSetTemp() {
		for (int i = 0; i < cardLeng * 2; i++) {
	    	cardButton[i].setText("");
	    }
	}
}
