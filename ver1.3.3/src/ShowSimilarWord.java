
public class ShowSimilarWord {
	
	/*
	 * �Ʒ����ʹ� �˻�����Դϴ�!! 201902664 �輺�� (5�� 22�� ������ ���� 10�� 30��)
	 */
	
	//��Ȯ�� ��� �޼ҵ�!!!!!!!!!!!!!!!!!!!!
	public void calHowMatch(WordBook exer, String input) {				//�Ű�����: (�ܾ� �迭. ���� �Է��� �ܾ�) �Է�// 1������: �ܾ��Է��ε� ��ü����,,,
		/*
		 * �Է��� �ܾ�� ������ �ܾ �ִ��� �迭Ÿ�� �Ű������� �Է¹ް�, �� �迭�� ���ҵ��� ������ �ø��� �ѹ����� ������ ���� ���絵�� ����Ѵ�,
		 * ������ ������ ����. 
		 * 29���� �ø��� �ѹ��� ���� 
		 * index 0-28 ���� ������ ��ġ�̸鼭 ������ ���� �� �������� sum�� 1�� ���Ѵ�.
		 * �׷��� �ݺ������� ���� sum ���� serialNumber ũ��� ������ *100 �Ѵ�
		 *	���絵 match =  sum/(serialNumber �� ũ��=29)*100 (%)
		 */
				//��� �ܾ�� ���絵�� �ο��ϵ��� ���絵�� ���� �迭�� ����
		
			Word word = new Word();
			
			word.setEnglish(input);
			word.setSerialNumber();		//�Է¹��� ��� ���� �ø���ѹ��� �����մϴ�.
			double match;
					//�ܾ��忡 �ִ� �ܾ�� �ݺ�
					//double type �� ����; match_array �� ���� = sum/�ø��� �ѹ����� *100 �� / �����ϱ� ������: Q) �¾� �μ���? 
			
			for(int i = 0; i<exer.getWord_array().length; i++) {
				
				double sum = 0;
				for(int j = 0; j<word.getSerialNumber().length; j++) {
					exer.getWord_array()[i].setSerialNumber();//�߰� ��ɾ�
					if(exer.getWord_array()[i].getSerialNumber()[j]==word.getSerialNumber()[j])
						sum+=1;
				}
					match = sum/exer.getWord_array()[i].getSerialNumber().length*100;
					exer.getWord_array()[i].setMatch(match);				//��
							//�ܾ� ��ü�� �ʵ��� match �� �����Ѵ�!
					
			}
			
		
	}
	
	//��Ȯ�� �ʱ�ȭ �޼ҵ� (calHowMatch �Ŀ� �ʼ�)
	public static void formatMatch(WordBook exer){
			for(int i =0; i<exer.getWord_array().length; i++) {
				exer.getWord_array()[i].setMatch(0.0);	
			}
	}
	
	//�� �ܾ� ����!(���� �Ͻ���)(����: calHowMatch �� ����Ǿ� �Ѵ�,)
	public static String SimilarWord (Word[] word_array) {
		
		String show;
		Word[] temporaryWord_array = word_array;						//�ӽ� �ܾ����� word_array �� �����Ѵ�.
		
		for(int j=temporaryWord_array.length; j>0; j--) {
			 for(int i = 0; i<j-1; i++) {			//2//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(temporaryWord_array[i].getMatch()>temporaryWord_array[i+1].getMatch()) {
					SortWord.sortOnlyEnglish(temporaryWord_array, i, i+1);
	
				}//if��
			}//for - i
		}//for-j
		
		//������ setIndex �� ������ �������Ƿ� temporaryWord_array �� �ܾ���� �ε����� ���ĵ� ������ word_array �� �ܾ���� �ε����� ����!
		show = "���� �ܾ ã���ʴϱ�?"+temporaryWord_array[0].getEnglish();
		return show;
	}

	

}
