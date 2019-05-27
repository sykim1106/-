public class Word {
	
	private String english;
	private String korean;
	private double match=0;// 단어 유사도
	public int[] serialNumber;		//시리얼 넘버
	
	public Word() {
		
	}
	//설정자 2019 05 19 12 31 a.m
	public void setSerialNumber() {									//자료형 타입 자꾸 헷갈리네
		String s=null;
		int[] arr= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};			//29개... 공식적인 단어로 가장긴 단어가 29자...
		for(int i= 0; i<english.length(); i++) {
			if(english.charAt(i)!=' ') {
				arr[i]=(english.charAt(i)-'a'+1);
			}
			if(english.charAt(i)==' '){
				arr[i]=0;//공백 때문에 우선순위가 바뀌므로  스페이스 바는 -1! 예)sort 하면 a liitle/ absorb 순임
				
			}
		}
		this.serialNumber=arr;
	}
	
	

	//유사도 설정자
	public void setMatch(double match) {
		this.match=match;
	}
	public void setEnglish(String english) {
		this.english=english;
	}
	
	public void setKorean(String korean) {
		this.korean=korean;
	}
	//접근자
	

	public double getMatch() {
		return match;
	}
	
	public String getEnglish() {
		return english;
	}

	public String getKorean() {
		return korean;
	}

	public Word(String english, String korean) {
		this.english=english;
		this.korean=korean;
	}
	
	public String toString() {
		return   "【단어】"+this.english+ " \n          "+"【뜻】"+this.korean + "\n";
	}
	
	//시리얼 넘버?=김성윤
	
	public int[] getSerialNumber() {
		return this.serialNumber;
	}
}
