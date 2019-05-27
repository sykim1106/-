
public class SortWord {
	
	public static void sortWord(Word[] word, int i, int j) {
		
		String temporary_space1;		//임시 데이터1
		String temporary_space2;		//임시 데이터2
		int[] temporary_serialarray1;	//word[i]의 임시 씨리얼넘버
		double temporary_match;
		
		temporary_space1 = word[i].getEnglish();
		temporary_space2= word[i].getKorean();
		temporary_serialarray1 = word[i].getSerialNumber();
		temporary_match = word[i].getMatch();
		
		word[i].setEnglish(word[j].getEnglish());
		word[i].setKorean(word[j].getKorean());
		word[j].setEnglish(temporary_space1);
		word[j].setKorean(temporary_space2);
		word[i].serialNumber = word[j].getSerialNumber();
		word[j].serialNumber = temporary_serialarray1;
		word[i].setMatch(word[j].getMatch());
		word[j].setMatch(temporary_match);
	}
	
	public static void sortOnlyEnglish(Word word[], int i, int j) {
		
		String temporary_space1;		//임시 데이터1
		
		int[] temporary_serialarray1;	//word[i]의 임시 씨리얼넘버
		double temporary_match;
		
		temporary_space1 = word[i].getEnglish();
		
		temporary_serialarray1 = word[i].getSerialNumber();
		temporary_match = word[i].getMatch();
		
		word[i].setEnglish(word[j].getEnglish());
		
		word[j].setEnglish(temporary_space1);
		
		word[i].serialNumber = word[j].getSerialNumber();
		word[j].serialNumber = temporary_serialarray1;
		word[i].setMatch(word[j].getMatch());
		word[j].setMatch(temporary_match);
		
	}

}
