/*
 * VocaExercise.java
 * monologue96
 */

/*
 * Changelog
 * 2019-05-16 추가, 삭제, 조회, 수정 메소드 추가 및 테스트코드 작성
 * 2019-05-17
 *  
 * - 어제 간단하게 만든 메소드들(추가, 삭제, 수정, 조회 등)을 파라미터 없는 메소드로 바꿨다. 
 * 일일이 입력받은 값을 변수 선언해서 저장하고 파라미터에 넘겨주는 일을 main 메소드에서 하는것보단 
 * 그냥 클래스(설계도)내 메소드에 사용자 입력값을 받는 코드까지 다 작성해두는 게 나을 것 같다.
 * 
 * - 어제는 그냥 메소드 테스트만 했다면, 오늘은 아래 기능을 추가했다.
 * 1. 시작화면(토익/ 토플 중 선택, 또는 프로그램 종료)
 * 2. 유형 선택 화면 ( 단어 / 숙어 )
 * 3. 메뉴페이지 ( 기능 선택, 초기화면 이동 기능 )
 *      > 전체 단어 리스트 표시, 단어 추가, 단어 삭제, 단어 수정, 검색, 초기화면
 * 4. 각 기능들을 실행할 때에도 '뒤로가기' 에 해당하는 취소 옵션을 추가했다.
 */

import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		/*
		 * 초기 화면을 표시하는 메소드 필요할 것 같다
		 * 초기 화면에는 조회, 추가, 수정 , 삭제, 테스트(일단 나중에), 종료 순으로 메뉴 표시
		 * 사용자가 프로그램을 사용하는 내내 예외 상황을 고려해야 하는데 이게 제일 막막하다..
		 */
		Scanner input = new Scanner(System.in);
		
		// 토익단어, 토익숙어, 토플단어, 토플숙어 객체 생성
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
			System.out.println("||                                          3. 종 료                                          ||");
			System.out.println("============================================");
			System.out.print("\n【 메뉴 선택】 ");
			int intro1_choose = input.nextInt();
			
			switch (intro1_choose) {
			case 1: // TOEIC 선택시
				System.out.println();
				System.out.println("============================================");
				System.out.println("||                                                                                              ||");
				System.out.println("||                                      유형 선택		                                  ||");
				System.out.println("||                                                                                              ||");
				System.out.println("============================================");
				System.out.println("||                  1. 단어                |                    2. 숙어              	  ||");
				System.out.println("============================================");
				System.out.print("\n 【유형 선택】 ");
				int toeic_type_choose = input.nextInt();

			
				switch (toeic_type_choose) {
				case 1:		// 토익 단어		
		ToeicWLoop: while(true) {
					
						switch (toeic_word.showMainPage()) {
						case 1:
							toeic_word.getWordList();

							break;
							
						case 2:
							do { 
								if(toeic_word.addWord()==false)
									continue ToeicWLoop;
								System.out.println("\n[1. 계속 추가] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);

							break;
							
						case 3:
							do { 
								if(toeic_word.removeWord()==false)
									continue ToeicWLoop;
								System.out.println("\n[1. 계속 삭제] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);
		
							break;
							
						case 4:
							do { 
								if(toeic_word.editWord()==false)
									continue ToeicWLoop;
								System.out.println("\n[1. 계속 수정] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);
					
							break;
						
						case 5:
							do { 
								toeic_word.findWord();
								System.out.println("\n[1. 계속 검색] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);
							
							break;
							
						case 6:
							
							continue Loop;
							
						case 7:
							//switch 문 생성
							TestBook tWordNote = new TestBook();				//자식클래스를 생성한다
							//필드인 단어장을 base class 의 객체의 필드(word_array)에게 물려받는다.
							tWordNote.getWordNote(toeic_word.getWord_array());
							//이제 단어장이 상속받았고 단어게임 시작화면을 띄운다.
							switch(tWordNote.StartTest()) {
							case 1:					
								//단어 시험을 합니다.//
								System.out.println("원하는 횟수를 입력하세요");
								int wanted_count = input.nextInt();
								
								for(int i =0; i<wanted_count; i++) {
									tWordNote.isCorrectWord();
								}
								break;
							case 2:		
								break;							//단어 시험 시작 취소
							}
																	//Q) 여기 break 맞
							break;
							
						default:
							System.out.println("\n다시 입력하세요.");
							
							break;
						}
					}					
				
					
				case 2:	// 토익 숙어
					
					
				default: 
					break;
				}	// 토익 토플 선택 switch문 case 1 end
				
				
			case 2: // TOEFL 선택시
				System.out.println();
				System.out.println("============================================");
				System.out.println("||                                                                                              ||");
				System.out.println("||                                        유형 선택		                                  ||");
				System.out.println("||                                                                                              ||");
				System.out.println("============================================");
				System.out.println("||       1. 단어                              |                                2. 숙어	  ||");
				System.out.println("============================================");
				System.out.print("\n 【유형 선택】 ");
				int toefl_type_choose = input.nextInt();
				
				switch (toefl_type_choose) {
				case 1:		// 토플 단어		
		ToeflWLoop: while(true) {
						switch (toefl_word.showMainPage()) {
						case 1:
							toefl_word.getWordList();
							break;
							
						case 2:
							do { 
								if(toefl_word.addWord()==false)
									continue ToeflWLoop;
								System.out.println("\n[1. 계속 추가] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);
							break;
							
						case 3:
							do { 
								if(toefl_word.removeWord()==false)
									continue ToeflWLoop;
								System.out.println("\n[1. 계속 삭제] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);
							break;
							
						case 4:
							do { 
								if(toefl_word.editWord()==false)
									continue ToeflWLoop;
								System.out.println("\n[1. 계속 수정] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);
							break;
						
						case 5:
							do { 
								toefl_word.findWord();
								System.out.println("\n[1. 계속 검색] [2. 돌아가기]");
								System.out.println("선택>> ");
							}while(input.nextInt()==1);
							break;
							
						case 6:
							continue Loop;
							
						default:
							System.out.println("\n다시 입력하세요.");
							break;
						}
					}					
				
					
				case 2:	// 토플 숙어
					
				default:
					break;
				}	// 토익 토플 선택 switch문 case 1 end
				
				
			case 3:
				System.out.println("\n >>>>>>>>>>>>>>> 프로그램 종료 <<<<<<<<<<<<<<<");
				break Loop;
			default:
				System.out.println("잘못 선택하였습니다. 초기화면으로 돌아갑니다.");
				continue Loop;
			
			}	// switch(intro1_choose) end
		}	// Loop End
	}
}
