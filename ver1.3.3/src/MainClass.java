/*
 * VocaExercise.java
 * monologue96
 */

/*
 * Changelog
 * 2019-05-16 �߰�, ����, ��ȸ, ���� �޼ҵ� �߰� �� �׽�Ʈ�ڵ� �ۼ�
 * 2019-05-17
 *  
 * - ���� �����ϰ� ���� �޼ҵ��(�߰�, ����, ����, ��ȸ ��)�� �Ķ���� ���� �޼ҵ�� �ٲ��. 
 * ������ �Է¹��� ���� ���� �����ؼ� �����ϰ� �Ķ���Ϳ� �Ѱ��ִ� ���� main �޼ҵ忡�� �ϴ°ͺ��� 
 * �׳� Ŭ����(���赵)�� �޼ҵ忡 ����� �Է°��� �޴� �ڵ���� �� �ۼ��صδ� �� ���� �� ����.
 * 
 * - ������ �׳� �޼ҵ� �׽�Ʈ�� �ߴٸ�, ������ �Ʒ� ����� �߰��ߴ�.
 * 1. ����ȭ��(����/ ���� �� ����, �Ǵ� ���α׷� ����)
 * 2. ���� ���� ȭ�� ( �ܾ� / ���� )
 * 3. �޴������� ( ��� ����, �ʱ�ȭ�� �̵� ��� )
 *      > ��ü �ܾ� ����Ʈ ǥ��, �ܾ� �߰�, �ܾ� ����, �ܾ� ����, �˻�, �ʱ�ȭ��
 * 4. �� ��ɵ��� ������ ������ '�ڷΰ���' �� �ش��ϴ� ��� �ɼ��� �߰��ߴ�.
 */

import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		/*
		 * �ʱ� ȭ���� ǥ���ϴ� �޼ҵ� �ʿ��� �� ����
		 * �ʱ� ȭ�鿡�� ��ȸ, �߰�, ���� , ����, �׽�Ʈ(�ϴ� ���߿�), ���� ������ �޴� ǥ��
		 * ����ڰ� ���α׷��� ����ϴ� ���� ���� ��Ȳ�� ����ؾ� �ϴµ� �̰� ���� �����ϴ�..
		 */
		Scanner input = new Scanner(System.in);
		
		// ���ʹܾ�, ���ͼ���, ���ôܾ�, ���ü��� ��ü ����
		WordBook toeic_word = new WordBook();						
		//ChunkExercise toeic_chunk = new ChunkExercise(2);
		WordBook toefl_word = new WordBook();
		//ChunkExercise toefl_chunk = new ChunkExercise(4);
	
	
		Loop: while(true) {
			System.out.println();
			System.out.println("**************************************************");
			System.out.println("||                                                                                               ||");
			System.out.println("||                                 TOEIC & TOEFL                                  ||");
			System.out.println("||                               VOCA  EXERCISE                                ||");
			System.out.println("||                                                                                               ||");
			System.out.println("__________________________________________________");
			System.out.println("||                   1. TOEIC              |                  2. TOEFL            ||");
			System.out.println("============================================");
			System.out.println("||                                          3. �� ��                                          ||");
			System.out.println("============================================");
			System.out.print("\n�� �޴� ���á� ");
			int intro1_choose = input.nextInt();
			
			switch (intro1_choose) {
			case 1: // TOEIC ���ý�
				System.out.println();
				System.out.println("============================================");
				System.out.println("||                                                                                              ||");
				System.out.println("||                                      ���� ����		                                  ||");
				System.out.println("||                                                                                              ||");
				System.out.println("============================================");
				System.out.println("||                  1. �ܾ�                |                    2. ����              	  ||");
				System.out.println("============================================");
				System.out.print("\n ������ ���á� ");
				int toeic_type_choose = input.nextInt();

			
				switch (toeic_type_choose) {
				case 1:		// ���� �ܾ�		
		ToeicWLoop: while(true) {
					
						switch (toeic_word.showMainPage()) {
						case 1:
							toeic_word.getWordList();

							break;
							
						case 2:
							do { 
								if(toeic_word.addWord()==false)
									continue ToeicWLoop;
								System.out.println("\n[1. ��� �߰�] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);

							break;
							
						case 3:
							do { 
								if(toeic_word.removeWord()==false)
									continue ToeicWLoop;
								System.out.println("\n[1. ��� ����] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);
		
							break;
							
						case 4:
							do { 
								if(toeic_word.editWord()==false)
									continue ToeicWLoop;
								System.out.println("\n[1. ��� ����] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);
					
							break;
						
						case 5:
							do { 
								toeic_word.findWord();
								System.out.println("\n[1. ��� �˻�] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);
							
							break;
							
						case 6:
							
							continue Loop;
							
						case 7:
							//switch �� ����
							TestBook tWordNote = new TestBook();				//�ڽ�Ŭ������ �����Ѵ�
							//�ʵ��� �ܾ����� base class �� ��ü�� �ʵ�(word_array)���� �����޴´�.
							tWordNote.getWordNote(toeic_word.getWord_array());
							//���� �ܾ����� ��ӹ޾Ұ� �ܾ���� ����ȭ���� ����.
							switch(tWordNote.StartTest()) {
							case 1:					
								//�ܾ� ������ �մϴ�.//
								System.out.println("���ϴ� Ƚ���� �Է��ϼ���");
								int wanted_count = input.nextInt();
								
								for(int i =0; i<wanted_count; i++) {
									tWordNote.isCorrectWord();
								}
								break;
							case 2:		
								break;							//�ܾ� ���� ���� ���
							}
																	//Q) ���� break ��
							break;
							
						default:
							System.out.println("\n�ٽ� �Է��ϼ���.");
							
							break;
						}
					}					
				
					
				case 2:	// ���� ����
					
					
				default: 
					break;
				}	// ���� ���� ���� switch�� case 1 end
				
				
			case 2: // TOEFL ���ý�
				System.out.println();
				System.out.println("============================================");
				System.out.println("||                                                                                              ||");
				System.out.println("||                                        ���� ����		                                  ||");
				System.out.println("||                                                                                              ||");
				System.out.println("============================================");
				System.out.println("||       1. �ܾ�                              |                                2. ����	  ||");
				System.out.println("============================================");
				System.out.print("\n ������ ���á� ");
				int toefl_type_choose = input.nextInt();
				
				switch (toefl_type_choose) {
				case 1:		// ���� �ܾ�		
		ToeflWLoop: while(true) {
						switch (toefl_word.showMainPage()) {
						case 1:
							toefl_word.getWordList();
							break;
							
						case 2:
							do { 
								if(toefl_word.addWord()==false)
									continue ToeflWLoop;
								System.out.println("\n[1. ��� �߰�] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);
							break;
							
						case 3:
							do { 
								if(toefl_word.removeWord()==false)
									continue ToeflWLoop;
								System.out.println("\n[1. ��� ����] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);
							break;
							
						case 4:
							do { 
								if(toefl_word.editWord()==false)
									continue ToeflWLoop;
								System.out.println("\n[1. ��� ����] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);
							break;
						
						case 5:
							do { 
								toefl_word.findWord();
								System.out.println("\n[1. ��� �˻�] [2. ���ư���]");
								System.out.println("����>> ");
							}while(input.nextInt()==1);
							break;
							
						case 6:
							continue Loop;
							
						default:
							System.out.println("\n�ٽ� �Է��ϼ���.");
							break;
						}
					}					
				
					
				case 2:	// ���� ����
					
				default:
					break;
				}	// ���� ���� ���� switch�� case 1 end
				
				
			case 3:
				System.out.println("\n >>>>>>>>>>>>>>> ���α׷� ���� <<<<<<<<<<<<<<<");
				break Loop;
			default:
				System.out.println("�߸� �����Ͽ����ϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
				continue Loop;
			
			}	// switch(intro1_choose) end
		}	// Loop End
	}
}
