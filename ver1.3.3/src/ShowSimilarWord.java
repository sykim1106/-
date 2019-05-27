
public class ShowSimilarWord {
	
	/*
	 * 아래부터는 검색기능입니다!! 201902664 김성윤 (5월 22일 수요일 오전 10시 30분)
	 */
	
	//정확도 계산 메소드!!!!!!!!!!!!!!!!!!!!
	public void calHowMatch(WordBook exer, String input) {				//매개변수: (단어 배열. 내가 입력한 단어) 입력// 1차수정: 단어입력인데 객체형식,,,
		/*
		 * 입력한 단어와 유사한 단어가 있는지 배열타입 매개변수를 입력받고, 이 배열의 원소들의 각각의 시리얼 넘버들을 연산을 통해 유사도를 계산한다,
		 * 공식은 다음과 같다. 
		 * 29자의 시리얼 넘버에 대해 
		 * index 0-28 까지 동일한 위치이면서 동일한 값이 면 지역변수 sum에 1을 더한다.
		 * 그렇게 반복문으로 나온 sum 값을 serialNumber 크기로 나누고 *100 한다
		 *	유사도 match =  sum/(serialNumber 의 크기=29)*100 (%)
		 */
				//모든 단어에게 유사도를 부여하도록 유사도를 담을 배열을 생성
		
			Word word = new Word();
			
			word.setEnglish(input);
			word.setSerialNumber();		//입력받은 영어에 대해 시리얼넘버를 설정합니다.
			double match;
					//단어장에 있는 단어들 반복
					//double type 인 이유; match_array 의 원소 = sum/시리얼 넘버길이 *100 의 / 연산하기 때문임: Q) 맞아 민수야? 
			
			for(int i = 0; i<exer.getWord_array().length; i++) {
				
				double sum = 0;
				for(int j = 0; j<word.getSerialNumber().length; j++) {
					exer.getWord_array()[i].setSerialNumber();//추가 명령어
					if(exer.getWord_array()[i].getSerialNumber()[j]==word.getSerialNumber()[j])
						sum+=1;
				}
					match = sum/exer.getWord_array()[i].getSerialNumber().length*100;
					exer.getWord_array()[i].setMatch(match);				//으
							//단어 객체의 필드인 match 에 설정한다!
					
			}
			
		
	}
	
	//정확도 초기화 메소드 (calHowMatch 후에 필수)
	public static void formatMatch(WordBook exer){
			for(int i =0; i<exer.getWord_array().length; i++) {
				exer.getWord_array()[i].setMatch(0.0);	
			}
	}
	
	//정 단어 정렬!(아주 일시적)(주의: calHowMatch 가 선행되야 한다,)
	public static String SimilarWord (Word[] word_array) {
		
		String show;
		Word[] temporaryWord_array = word_array;						//임시 단어장이 word_array 를 참조한다.
		
		for(int j=temporaryWord_array.length; j>0; j--) {
			 for(int i = 0; i<j-1; i++) {			//2//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(temporaryWord_array[i].getMatch()>temporaryWord_array[i+1].getMatch()) {
					SortWord.sortOnlyEnglish(temporaryWord_array, i, i+1);
	
				}//if문
			}//for - i
		}//for-j
		
		//어차피 setIndex 를 위에서 안했으므로 temporaryWord_array 의 단어들의 인덱스는 정렬된 기존의 word_array 의 단어들의 인덱스와 같다!
		show = "다음 단어를 찾으십니까?"+temporaryWord_array[0].getEnglish();
		return show;
	}

	

}
