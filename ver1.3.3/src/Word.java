public class Word {
	
	private String english;
	private String korean;
	private double match=0;// �ܾ� ���絵
	public int[] serialNumber;		//�ø��� �ѹ�
	
	public Word() {
		
	}
	//������ 2019 05 19 12 31 a.m
	public void setSerialNumber() {									//�ڷ��� Ÿ�� �ڲ� �򰥸���
		String s=null;
		int[] arr= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};			//29��... �������� �ܾ�� ����� �ܾ 29��...
		for(int i= 0; i<english.length(); i++) {
			if(english.charAt(i)!=' ') {
				arr[i]=(english.charAt(i)-'a'+1);
			}
			if(english.charAt(i)==' '){
				arr[i]=0;//���� ������ �켱������ �ٲ�Ƿ�  �����̽� �ٴ� -1! ��)sort �ϸ� a liitle/ absorb ����
				
			}
		}
		this.serialNumber=arr;
	}
	
	

	//���絵 ������
	public void setMatch(double match) {
		this.match=match;
	}
	public void setEnglish(String english) {
		this.english=english;
	}
	
	public void setKorean(String korean) {
		this.korean=korean;
	}
	//������
	

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
		return   "���ܾ"+this.english+ " \n          "+"���桽"+this.korean + "\n";
	}
	
	//�ø��� �ѹ�?=�輺��
	
	public int[] getSerialNumber() {
		return this.serialNumber;
	}
}
