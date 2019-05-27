import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * 작성자: 201902664 김성윤
 * 목적: 메소드들 리턴 타입을 int 하는 이유는 메인클래스에서 switch 문으로 작성하기 위함이다.
 */
public class TestBook extends WordBook{			//나중에 이름은 Testable_Investigatable_WordExerCise
	//Test전용 단어장 
	private Word[] TestableWordNote = {};
	//시험 점수
	private int score;
	
	
	//단어 기회 필드
	private static final int oppertunity = 5;	
	
	//틀린 개수 Q)작명 구림 help...
	private int howManyYouX = 0;									
	/*
	*isNotCorrect메소드를 통해 howManyYouX 가 oppertunity와 같아지면  Testable_WordExercise 종료시키기 위함
	*/
	//단어시험 점수 접근자
	public int getScore() {
		return score;
	}
	//단어장을 불러오는 메소드
	public Word[] getWordNote(Word[] WordNote) {
		for(Word value : WordNote) {
			List<Word> TestableWordNote1 = new ArrayList<>(Arrays.asList(WordNote));
			TestableWordNote1.add(value);
			TestableWordNote = TestableWordNote1.toArray(new Word[TestableWordNote1.size()]);	
		}
		return TestableWordNote;	//테스트 전용 단어장!!!!!!
	}
	//단어 시작 전 메소드
	public int StartTest() {
		System.out.println("단어 시험을 시작하시겠습니까? 1.예              2. 아니오>>");
		int chooseNumber = input.nextInt();
		return chooseNumber;							//입력한 정수 값을 리턴한다.  switch 문 의 case 1: case 2:
	}
	
	//점수 집계 메소드
	public int collectPoint(boolean isCorrect) {
		if(isCorrect==true) {
			score += 5;
			return score;		//+5점 Q) 
		}
		else {
			return score;		//그대로
		}
	}
	
	// 단어 일치여부 확인 메소드: (일단 단어 1개만) 리턴값은 맞으면 true/틀리면 false
	public void isCorrectWord() {
		//난수 발생 
		Random generator = new Random();
		//단어장애의 인덱스 값중 임의로 가져와서 저장
		int random_indexOfTestableWordNote= generator.nextInt(TestableWordNote.length);
		
		input.nextLine();
		
		System.out.println();
		System.out.println("\n 다음 【뜻】에 맞는 단어를 적으시오 ");		// 정확하게 입력하지 않아도 유사한 것을 보여줄 수 없을까
		System.out.println(TestableWordNote[random_indexOfTestableWordNote].getKorean());
		
		System.out.print("\n 【단어】: ");
		String target = input.nextLine();
		if(target.equals(TestableWordNote[random_indexOfTestableWordNote].getEnglish())) {
				System.out.println("정답!");
			}
		
		else {
				System.out.println("틀렸습니다. 답은 \n"+TestableWordNote[random_indexOfTestableWordNote].getEnglish()+"입니다");
		}
		System.out.println("다음 문제로 넘어가시려면 [Enter] 키를 눌러주세요!");
		
	}//isCorrectWord
	
	

	
}
