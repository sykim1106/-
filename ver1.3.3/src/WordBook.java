/*
 * WordExercise.java
 * monologue96
 */

import java.util.*;

class WordBook {
	Scanner input = new Scanner(System.in);
	//201902664�輺�� �������� private �� ������
	private Word[] word_array = {};
	
	//������
	public void setWord_array(Word[] word_array) {
		this.word_array= word_array;
	}
	
	//������
	public Word[] getWord_array() {
		
		return word_array;
	}	
		// Q) WordExercise Ŭ������ �� ��ü toeic_word �� toefl_word �� ������ �� word_array ������ ���� �ٸ��� �ϰ� ������...
	
	/*
	public WordExercise(int i) {
		switch (i) {
		case 1: 
			word_array = {"abbreviated","abide", "able"};
			meaning_array = {"�����, ������, �����ϰ� ��", "�ӹ�����, ���", "�� �� �ִ�, ������, �ڰ� �ִ�"};
		}
	}
	*/

	// �ʱ�ȭ�� �޼ҵ�
	public int showMainPage() {
		System.out.println("\n=========================================================================");
		System.out.println("| 1. ��ü �ܾ� ����Ʈ  | 2. �ܾ� �߰�  | 3. �ܾ� ����  | 4. �ܾ� ����  | 5. �˻�  | 6. �ʱ�ȭ��  | 7. �ܾ��׽�Ʈ");
		System.out.println("=========================================================================");
		System.out.print("\n �޴� ��ȣ �Է�>> ");
		
		return input.nextInt();
	}
	
	// ��� �ܾ� ����Ʈ ǥ�� �޼ҵ�         --�� ������ �ϳ� �� ������µ� (getWord_array)
	public void getWordList() {
		
		for(Word value: word_array)			//word_array �� �ִ� ��� �ܾ� Word �� ���� serial Number �� �����մϴ�;
			value.setSerialNumber();
		this.SortWord(this.getWord_array());//serialNumber ��  ������ ���¿��� �����մϴ�.
		
		System.out.println("\n=============���� ���ܾ� ����Ʈ=============\n");
		for(int i=0; i<word_array.length; i++) {
			System.out.println((i+1) + "   " + word_array[i].toString());
		}
		System.out.println("=======================================");

	}
	
	
	// �ܾ� �߰� �޼ҵ�
	public boolean addWord() {
		
		System.out.println("\n���� ���ܾ� ���� : " + word_array.length);
		System.out.println("�߰��� ���ܾ� �Է�>> ");
		
		input.nextLine();//sykim1106
		
		String eng = input.nextLine();//line ���� �Ʒ� "�� �Է�>>" print���� ���� ����Ǿ� ����...
		
		System.out.println("�� �Է�>> ");
		String kor = input.nextLine();
		
		Word word1 = new Word(eng,kor);													/////////////////////////////////�輺����
		
		
		System.out.println("\n[1. ����Ʈ�� �߰�] | [2. �Է� ���]");	// Q) 1,2 �� �ٸ� �� �Է½� �ٽ� �Է��ϰ� �ϴ� ����ó�� �ʿ�
		System.out.println("����>> ");
		
		if(input.nextInt()==1) {
			List<Word> w_list = new ArrayList<>(Arrays.asList(word_array));
			w_list.add(word1);
			word_array = w_list.toArray(new Word[w_list.size()]);	
			
			
			
			return true;
		}else return false;
		
	}
	
	// �ܾ� ���� �޼ҵ�
	public boolean removeWord() {
		this.getWordList();		// �ܾ��Ʈ ǥ��
		
		System.out.println("\n ������ ���ܾ� ��ȣ �Է� (����Ϸ��� 0�� �����ʽÿ�) >> ");
		int index = input.nextInt();

		if(0 <= index-1 && index-1 <= word_array.length) {
			// ���� ����
			List<Word> w_list = new ArrayList<>(Arrays.asList(word_array));
			w_list.remove(w_list.get(index-1));
			word_array = w_list.toArray(new Word[w_list.size()]);
			
			return true;
			
		}else if(index==0){
			return false;
		}else{
			System.out.println("�Է��� ��ȣ�� �ش��ϴ� �ܾ �����ϴ�. �ٽ� �Է��ϼ���");	
			// Q) ���࿡ �� �����ϰ� ���� ��? -> �ܾ 1�� �̻� �������� ���� �Լ��� ����ǵ��� ó���ؾ��ҵ�
			removeWord();
			return true;
		}
			
	}
	
	// �ܾ� ���� �޼ҵ�	
	public boolean editWord() {
		
		System.out.println("-------------------------------------------------");
		System.out.println("| 1. ��� ����  | 2. �游 ����   | 3. �� �� ����  |  4. ���   |");
		System.out.println("-------------------------------------------------");

		System.out.println("�ɼ� ����>> ");
		int option = input.nextInt();
		if(1 <= option && option <=3) {
			this.getWordList();
			System.out.println("\n[������ �ܾ� ��ȣ] >> ");
			int index = input.nextInt();
			
			if(0 <= index-1 && index-1 <= word_array.length) {
				switch (option) {
				case 1:
					System.out.println("[�������� �Է�] >> ");
					input.nextLine();
					String op1_eng = input.nextLine();
					
					word_array[index-1].setEnglish(op1_eng);
					break;
					
				case 2:
					System.out.println("�������� �Է� >> ");
					input.nextLine();
					String op2_kor = input.nextLine();
										
					word_array[index-1].setKorean(op2_kor);
					break;
				case 3:
					System.out.println("���ܾ� �������� �Է� >> ");
					input.nextLine();
					String edit_eng = input.nextLine();		// Q) ���� �����Ϸ��� nextLine ���� �����Ű�� �̻��ϰ� �۵���..---------->�輺��: ���� �ٿ� input.nextLine() �� �Ͻø� �˴ϴ�!
					
					word_array[index-1].setEnglish(edit_eng);
					
					System.out.println("�� �������� �Է� >> ");
					input.nextLine();
					String edit_kor = input.nextLine();
					
					word_array[index-1].setKorean(edit_kor);
					break;
				}
			}
			return true;
		}else if(option == 4) {
			return false;
		}else {
			System.out.println("\n�ٽ� �Է��ϼ���");
			editWord();
			return true;
		}
	}

	// �ܾ� ��ȸ �޼ҵ�
	public void findWord() {
		int found_word = 0;
		
		input.nextLine();
		System.out.println("\n�˻��� ���ܾ� �Է�>> ");		// ��Ȯ�ϰ� �Է����� �ʾƵ� ������ ���� ������ �� ������
		
		String target = input.nextLine();
		
		System.out.println("\n===============<�˻� ���>===============\n");
		for(int i=0 ; i<word_array.length ; i++) {
			if(target.equals(word_array[i].getEnglish())) {
				System.out.println((i+1) + "   " + word_array[i].toString());
				found_word++;
			}
			
			if (found_word == 0) {
				ShowSimilarWord s = new ShowSimilarWord();
				s.calHowMatch(this, target);					
				/*
				*������ ���� ����: Word �� �ʵ带 int[] Ÿ���� �迭�� serialNumber �� ����
				*���� �� �ʵ��� ������ ������ ���� �����ϰ� ������ public int[] getserialNumber �� ����,
				*(�ֳĸ� �ܾ� ��ü�� �����ϰ� �� �ʵ��� english �� null �̸� NPE �߻�
				*/
				
					System.out.print(ShowSimilarWord.SimilarWord(this.getWord_array()));
					
					ShowSimilarWord.formatMatch(this);
				}
				System.out.println("\n======================================\n");
		}
		
		
	}
	
	//�ܾ� ���� �޼ҵ�------------------201902664�輺��
	public void SortWord(Word[] word) {
		
		int number = word_array.length;
		
		for(int j=number; j>0; j--) {///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Loop1: for(int i = 0; i<j-1; i++) {
				
				Loop: for(int count = 0; count<word_array[i].getSerialNumber().length ; count++) {//word_array[i].getSerialNumber().length �� word
				
					if(word[i].getSerialNumber()[count] > word[i+1].getSerialNumber()[count]){
						SortWord.sortWord(word, i, i+1);
						continue Loop1;
					
					}else if(word[i].getSerialNumber()[count]==word[i+1].getSerialNumber()[count]) {
						
						continue Loop; /// �ٽ� count ++ �ؼ�  ��� ��
						
					}else {						
						continue Loop1;
					}
					
				}//for - count
				
				
			}//for - i
		}//for-j
		
	}

	


}

	