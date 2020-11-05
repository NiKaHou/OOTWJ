package wordCount_Visitor_Iterator;

//concrete visitor2
public class AnotherVisitor implements Visitor {
	
	private int AnotherNum = 0;
	
	@Override
	public void visit(EnglishWord ew) {
		// TODO Auto-generated method stub
		System.out.println("english word visit is nothing to do in this class");
	}

	@Override
	public void visit(AnotherWord cw) {
		// TODO Auto-generated method stub
		Iterator iter = cw.createIterator();
		
		while(!iter.chiisDone()) {
			AnotherNum++;
			iter.chiNext();
		}
	}
	
	@Override
	public int getWordCount() {
		return AnotherNum;
	}
}
