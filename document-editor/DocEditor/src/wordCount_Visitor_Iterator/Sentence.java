package wordCount_Visitor_Iterator;

import java.util.ArrayList;
import java.util.List;

//element also concrete aggregate
public abstract class Sentence implements Aggregate {
	
	List<EnglishWord> engWords = new ArrayList<EnglishWord>();
	List<AnotherWord> chiWords = new ArrayList<AnotherWord>();
	
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new SentenceIterator(this);
	}
	
	public abstract void accept(Visitor v);
	public abstract void add(String word);
}
