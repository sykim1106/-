/*
 * WordExercise.java
 * monologue96
 */

import java.util.*;

class WordBook {
	Scanner input = new Scanner(System.in);
	//201902664김성윤 수정사항 private 를 삭제함
	private Word[] word_array = {};
	
	//설정자
	public void setWord_array(Word[] word_array) {
		this.word_array= word_array;
	}
	
	//접근자
	public Word[] getWord_array() {
		
		return word_array;
	}	
		// Q) WordExercise 클래스의 두 객체 toeic_word 와 toefl_word 를 생성할 때 word_array 내용이 각각 다르게 하고 싶은데...
	
	/*
	public WordExercise(int i) {
		switch (i) {
		case 1: 
			word_array = {"abbreviated","abide", "able"};
			meaning_array = {"단축된, 약자의, 간결하게 한", "머무르다, 살다", "할 수 있는, 유능한, 자격 있는"};
		}
	}
	*/

	// 초기화면 메소드
	public int showMainPage() {
		System.out.println("\n=========================================================================");
		System.out.println("| 1. 전체 단어 리스트  | 2. 단어 추가  | 3. 단어 삭제  | 4. 단어 수정  | 5. 검색  | 6. 초기화면  | 7. 단어테스트");
		System.out.println("=========================================================================");
		System.out.print("\n 메뉴 번호 입력>> ");
		
		return input.nextInt();
	}
	
	// 모든 단어 리스트 표시 메소드         --으 접근자 하나 더 만들었는데 (getWord_array)
	public void getWordList() {
		
		for(Word value: word_array)			//word_array 에 있는 모든 단어 Word 에 대해 serial Number 를 설정합니다;
			value.setSerialNumber();
		this.SortWord(this.getWord_array());//serialNumber 를  설정한 상태에서 정렬합니다.
		
		System.out.println("\n=============현재 영단어 리스트=============\n");
		for(int i=0; i<word_array.length; i++) {
			System.out.println((i+1) + "   " + word_array[i].toString());
		}
		System.out.println("=======================================");

	}
	
	
	// 단어 추가 메소드
	public boolean addWord() {
		
		System.out.println("\n현재 영단어 개수 : " + word_array.length);
		System.out.println("추가할 영단어 입력>> ");
		
		input.nextLine();//sykim1106
		
		String eng = input.nextLine();//line 쓰면 아래 "뜻 입력>>" print문이 같이 실행되어 있음...
		
		System.out.println("뜻 입력>> ");
		String kor = input.nextLine();
		
		Word word1 = new Word(eng,kor);													/////////////////////////////////김성윤이
		
		
		System.out.println("\n[1. 리스트에 추가] | [2. 입력 취소]");	// Q) 1,2 외 다른 수 입력시 다시 입력하게 하는 예외처리 필요
		System.out.println("선택>> ");
		
		if(input.nextInt()==1) {
			List<Word> w_list = new ArrayList<>(Arrays.asList(word_array));
			w_list.add(word1);
			word_array = w_list.toArray(new Word[w_list.size()]);	
			
			
			
			return true;
		}else return false;
		
	}
	
	// 단어 삭제 메소드
	public boolean removeWord() {
		this.getWordList();		// 단어리스트 표시
		
		System.out.println("\n 삭제할 영단어 번호 입력 (취소하려면 0을 누르십시오) >> ");
		int index = input.nextInt();

		if(0 <= index-1 && index-1 <= word_array.length) {
			// 영어 삭제
			List<Word> w_list = new ArrayList<>(Arrays.asList(word_array));
			w_list.remove(w_list.get(index-1));
			word_array = w_list.toArray(new Word[w_list.size()]);
			
			return true;
			
		}else if(index==0){
			return false;
		}else{
			System.out.println("입력한 번호에 해당하는 단어가 없습니다. 다시 입력하세요");	
			// Q) 만약에 다 삭제하고 없을 땐? -> 단어가 1개 이상 있을때만 삭제 함수가 실행되도록 처리해야할듯
			removeWord();
			return true;
		}
			
	}
	
	// 단어 수정 메소드	
	public boolean editWord() {
		
		System.out.println("-------------------------------------------------");
		System.out.println("| 1. 영어만 수정  | 2. 뜻만 수정   | 3. 둘 다 수정  |  4. 취소   |");
		System.out.println("-------------------------------------------------");

		System.out.println("옵션 선택>> ");
		int option = input.nextInt();
		if(1 <= option && option <=3) {
			this.getWordList();
			System.out.println("\n[수정할 단어 번호] >> ");
			int index = input.nextInt();
			
			if(0 <= index-1 && index-1 <= word_array.length) {
				switch (option) {
				case 1:
					System.out.println("[수정내용 입력] >> ");
					input.nextLine();
					String op1_eng = input.nextLine();
					
					word_array[index-1].setEnglish(op1_eng);
					break;
					
				case 2:
					System.out.println("수정내용 입력 >> ");
					input.nextLine();
					String op2_kor = input.nextLine();
										
					word_array[index-1].setKorean(op2_kor);
					break;
				case 3:
					System.out.println("영단어 수정내용 입력 >> ");
					input.nextLine();
					String edit_eng = input.nextLine();		// Q) 공백 포함하려고 nextLine 쓰고 실행시키면 이상하게 작동함..---------->김성윤: 다음 줄에 input.nextLine() 을 하시면 됩니당!
					
					word_array[index-1].setEnglish(edit_eng);
					
					System.out.println("뜻 수정내용 입력 >> ");
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
			System.out.println("\n다시 입력하세요");
			editWord();
			return true;
		}
	}

	// 단어 조회 메소드
	public void findWord() {
		int found_word = 0;
		
		input.nextLine();
		System.out.println("\n검색할 영단어 입력>> ");		// 정확하게 입력하지 않아도 유사한 것을 보여줄 수 없을까
		
		String target = input.nextLine();
		
		System.out.println("\n===============<검색 결과>===============\n");
		for(int i=0 ; i<word_array.length ; i++) {
			if(target.equals(word_array[i].getEnglish())) {
				System.out.println((i+1) + "   " + word_array[i].toString());
				found_word++;
			}
			
			if (found_word == 0) {
				ShowSimilarWord s = new ShowSimilarWord();
				s.calHowMatch(this, target);					
				/*
				*에러로 인한 수정: Word 의 필드를 int[] 타입의 배열인 serialNumber 를 설정
				*따라서 이 필드의 설정자 접근자 따로 생성하고 기존의 public int[] getserialNumber 를 삭제,
				*(왜냐면 단어 객체만 생성하고 그 필드인 english 가 null 이면 NPE 발생
				*/
				
					System.out.print(ShowSimilarWord.SimilarWord(this.getWord_array()));
					
					ShowSimilarWord.formatMatch(this);
				}
				System.out.println("\n======================================\n");
		}
		
		
	}
	
	//단어 정렬 메소드------------------201902664김성윤
	public void SortWord(Word[] word) {
		
		int number = word_array.length;
		
		for(int j=number; j>0; j--) {///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Loop1: for(int i = 0; i<j-1; i++) {
				
				Loop: for(int count = 0; count<word_array[i].getSerialNumber().length ; count++) {//word_array[i].getSerialNumber().length 로 word
				
					if(word[i].getSerialNumber()[count] > word[i+1].getSerialNumber()[count]){
						SortWord.sortWord(word, i, i+1);
						continue Loop1;
					
					}else if(word[i].getSerialNumber()[count]==word[i+1].getSerialNumber()[count]) {
						
						continue Loop; /// 다시 count ++ 해서  대소 비교
						
					}else {						
						continue Loop1;
					}
					
				}//for - count
				
				
			}//for - i
		}//for-j
		
	}

	


}

	