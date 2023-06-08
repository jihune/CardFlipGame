import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GameResult {
	
	static boolean ggState = false;
	static JFrame frame;
	
	GameResult() {
		ggState = true;
		
        frame = new JFrame("END");
        frame.setPreferredSize(new Dimension(300, 250)); // 화면 크기
        frame.setLocationRelativeTo(null); // 프레임 화면 정가운데로 위치
        
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2 ,1));
        
        JPanel resultPane = new JPanel();
        resultPane.setLayout(new GridLayout(2 ,1));
        resultPane.setBorder(new TitledBorder("게임 결과"));
        
        JLabel successLabel = new JLabel("카드 뒤집기 성공 => " + CardPanel.successCount + "번");
        successLabel.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        
        JLabel levelLabel = new JLabel("현재 레벨 => " + GameWindow.level);
        levelLabel.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        
        resultPane.add(levelLabel);
        resultPane.add(successLabel);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(1 ,2));
        
        JButton resetButton = new JButton("다시 하기");
        ResetAction resetAc = new ResetAction();
        resetButton.addActionListener(resetAc);
        
        JButton levelUpButton = new JButton("다음 레벨");
        LevelUpAction lvUpAc = new LevelUpAction();
        levelUpButton.addActionListener(lvUpAc);
        
        buttonPane.add(resetButton);
        buttonPane.add(levelUpButton);
        
        contentPane.add(resultPane);
        contentPane.add(buttonPane);
        
        // ===프레임 마무리 설정==
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	frame.pack();
     	frame.setVisible(true);
	}
}
