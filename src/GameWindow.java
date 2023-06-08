import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GameWindow {
	
	// 카드 가로 1줄의 개수
	static int cardLeng = 6; // 레벨 업시 변화
	static int originCardLeng = cardLeng; // 게임 시작 때의 카드길이 보관
	
	// -레벨과 목숨 전역 변수-
	static int level = 1;
	static JLabel levelLabel = new JLabel();
	
	static int life = 3;
	static JLabel lifeLabel = new JLabel();
	
	// -리셋, 레벨업 클래스에 사용할수 있도록 컨텐츠 패널, 카드 패널을 전역변수로 지정-
	static Container contentPane; 
	static CardPanel cardPane;
	
	public static void main(String[] args) {
		
		// ===프레임 설정===
        JFrame frame = new JFrame("카드 뒤집기 게임");
        frame.setPreferredSize(new Dimension(800, 600)); // 화면 크기
        frame.setLocationRelativeTo(null); // 프레임 화면 정가운데로 위치
        
        // ===컨테이너 설정===
        contentPane = frame.getContentPane();

        // ===첫째줄 메뉴 패널===
        // -메뉴 패널 설정-
        JPanel menuPane = new JPanel();
        menuPane.setBorder(new TitledBorder("시작을 누르면 5초동안 카드 공개   |   리셋한 경우, 시작 버튼을 다시 클릭   |   뒤집기를 전부 성공하면, 결과 창의 다음 레벨버튼 작동")); // 메뉴 테두리바 설정
        menuPane.setLayout(new GridLayout(1, 5));// 메뉴패널 레이아웃 설정 1*5
        menuPane.setPreferredSize(new Dimension(600, 60));
		
        // -카운트다운 텍스트 창 생성-
        JTextField countDownText = new JTextField("카운트다운");
        countDownText.setHorizontalAlignment(JTextField.CENTER); // 가운데 정렬
        
        // -메뉴 버튼 생성-
        JButton reset = new JButton("리셋");
		JButton start = new JButton("시작");
		
		// -메뉴 라벨 생성-
		levelLabel.setText("레벨 => "+ level);
		levelLabel.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		
		lifeLabel.setText("목숨 => "+ life +"개"); // 초기 메세지
		lifeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// -메뉴에 버튼, 텍스트, 라벨 추가-
		menuPane.add(reset);
		menuPane.add(levelLabel);
		menuPane.add(countDownText);
		menuPane.add(lifeLabel);
		menuPane.add(start);
		
		// ===둘째줄 카드 패널===
		// -카드 패널 생성-
		cardPane = new CardPanel();
		cardPane.cardButtonGen();
		cardPane.cardPanelGen();
        
        // -시작 버튼 동작기능 추가-
		StartAction startAc = new StartAction(countDownText, cardPane);
		start.addActionListener(startAc);
		
		// -리셋 버튼 동작기능 추가-
		ResetAction resetAc = new ResetAction();
		reset.addActionListener(resetAc);
        
        // ===컨텐츠 패널에 메뉴, 카드패널 추가===
        contentPane.add(menuPane, BorderLayout.NORTH);
        contentPane.add(cardPane.getCardPanel(), BorderLayout.CENTER);
		
        // ===프레임 마무리 설정==
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}