package wordCount_Visitor_Iterator;


//concrete element1
public class EnglishWord extends Sentence {
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}
	
	@Override
	public void add(String word) {
		engWords.add(this);
	}
}
