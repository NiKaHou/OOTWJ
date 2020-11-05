package wordCount_Visitor_Iterator;


//concrete element2
public class AnotherWord extends Sentence {

	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}
	
	@Override
	public void add(String word) {
		chiWords.add(this);
	}
}
