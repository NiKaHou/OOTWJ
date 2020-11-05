package wordCount_Visitor_Iterator;

//concrete visitor1
public class EngVisitor implements Visitor {
	
	private int engWordNum = 0;
	
	@Override
	public void visit(EnglishWord ew) {
		// TODO Auto-generated method stub
		Iterator iter = ew.createIterator();
		
		while(!iter.engisDone()) {
			engWordNum++;
			iter.engNext();
		}
	}

	@Override
	public void visit(AnotherWord cw) {
		// TODO Auto-generated method stub
		System.out.println("chinese word visit is nothing to do in this class");
	}
	
	@Override
	public int getWordCount() {
		return engWordNum;
	}
}
