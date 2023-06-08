import java.util.Random;

public class RandomCard {
	
	private int cardListInteger1[];
	private int cardListInteger2[];
	
	private String cardListString1[];
	private String cardListString2[];
	
	private int maxCardNum;

	public void makeRandomCard(int maxCardNum) {
		this.maxCardNum = maxCardNum;
		
		cardListInteger1 = new int[maxCardNum];
		cardListInteger2 = new int[maxCardNum];
		
		Random random = new Random();
		
		for (int i = 0; i < maxCardNum; i++) {
        	cardListInteger1[i] = random.nextInt(8) + 1; // 1 ~ 9 사이의 랜덤 숫자 생성
        	cardListInteger2[i] = cardListInteger1[i];
        }
		
		cardListInteger2 = shuffle(cardListInteger2); // 카드 섞음
	}
	
	public int[] shuffle(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			int i = (int) (Math.random() * arr.length);
			int j = (int) (Math.random() * arr.length);

			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

		return arr;
	}
	
	public String[] getFirstCardList() {
		cardListString1 = new String[maxCardNum];
		
		for (int i = 0; i < maxCardNum; i++) {
			cardListString1[i] = Integer.toString(cardListInteger1[i]);
		}
		
		return cardListString1;
	}
	
	public String[] getSecondCardList() {
		cardListString2 = new String[maxCardNum];
		
		for (int i = 0; i < maxCardNum; i++) {
			cardListString2[i] = Integer.toString(cardListInteger2[i]);
		}
		
		return cardListString2;
	}
}
