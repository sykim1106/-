import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * �ۼ���: 201902664 �輺��
 * ����: �޼ҵ�� ���� Ÿ���� int �ϴ� ������ ����Ŭ�������� switch ������ �ۼ��ϱ� �����̴�.
 */
public class TestBook extends WordBook{			//���߿� �̸��� Testable_Investigatable_WordExerCise
	//Test���� �ܾ��� 
	private Word[] TestableWordNote = {};
	//���� ����
	private int score;
	
	
	//�ܾ� ��ȸ �ʵ�
	private static final int oppertunity = 5;	
	
	//Ʋ�� ���� Q)�۸� ���� help...
	private int howManyYouX = 0;									
	/*
	*isNotCorrect�޼ҵ带 ���� howManyYouX �� oppertunity�� ��������  Testable_WordExercise �����Ű�� ����
	*/
	//�ܾ���� ���� ������
	public int getScore() {
		return score;
	}
	//�ܾ����� �ҷ����� �޼ҵ�
	public Word[] getWordNote(Word[] WordNote) {
		for(Word value : WordNote) {
			List<Word> TestableWordNote1 = new ArrayList<>(Arrays.asList(WordNote));
			TestableWordNote1.add(value);
			TestableWordNote = TestableWordNote1.toArray(new Word[TestableWordNote1.size()]);	
		}
		return TestableWordNote;	//�׽�Ʈ ���� �ܾ���!!!!!!
	}
	//�ܾ� ���� �� �޼ҵ�
	public int StartTest() {
		System.out.println("�ܾ� ������ �����Ͻðڽ��ϱ�? 1.��              2. �ƴϿ�>>");
		int chooseNumber = input.nextInt();
		return chooseNumber;							//�Է��� ���� ���� �����Ѵ�.  switch �� �� case 1: case 2:
	}
	
	//���� ���� �޼ҵ�
	public int collectPoint(boolean isCorrect) {
		if(isCorrect==true) {
			score += 5;
			return score;		//+5�� Q) 
		}
		else {
			return score;		//�״��
		}
	}
	
	// �ܾ� ��ġ���� Ȯ�� �޼ҵ�: (�ϴ� �ܾ� 1����) ���ϰ��� ������ true/Ʋ���� false
	public void isCorrectWord() {
		//���� �߻� 
		Random generator = new Random();
		//�ܾ������ �ε��� ���� ���Ƿ� �����ͼ� ����
		int random_indexOfTestableWordNote= generator.nextInt(TestableWordNote.length);
		
		input.nextLine();
		
		System.out.println();
		System.out.println("\n ���� ���桽�� �´� �ܾ �����ÿ� ");		// ��Ȯ�ϰ� �Է����� �ʾƵ� ������ ���� ������ �� ������
		System.out.println(TestableWordNote[random_indexOfTestableWordNote].getKorean());
		
		System.out.print("\n ���ܾ: ");
		String target = input.nextLine();
		if(target.equals(TestableWordNote[random_indexOfTestableWordNote].getEnglish())) {
				System.out.println("����!");
			}
		
		else {
				System.out.println("Ʋ�Ƚ��ϴ�. ���� \n"+TestableWordNote[random_indexOfTestableWordNote].getEnglish()+"�Դϴ�");
		}
		System.out.println("���� ������ �Ѿ�÷��� [Enter] Ű�� �����ּ���!");
		
	}//isCorrectWord
	
	

	
}
