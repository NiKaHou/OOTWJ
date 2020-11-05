package wordCount_Visitor_Iterator;

//concrete iterator
public class SentenceIterator implements Iterator {
	
	private Sentence st;
	private int engCurrent = 0;
	private int chiCurrent = 0;
	
	public SentenceIterator(Sentence s) {
		this.st = s;
	}
	
	@Override
	public Object engFirst() {
		// TODO Auto-generated method stub
		return st.engWords.get(engCurrent);
	}

	@Override
	public Object engNext() {
		// TODO Auto-generated method stub
		Object ret = null;
		engCurrent++;
		
		if(engCurrent<st.engWords.size()) {
			ret = st.engWords.get(engCurrent);
		}
		
		return ret;
	}

	@Override
	public boolean engisDone() {
		// TODO Auto-generated method stub
		return engCurrent >= st.engWords.size() ? true : false;
	}

	@Override
	public Object engCurrentItem() {
		// TODO Auto-generated method stub
		return st.engWords.get(engCurrent);
	}
	
	@Override
	public Object chiFirst() {
		// TODO Auto-generated method stub
		return st.chiWords.get(chiCurrent);
	}

	@Override
	public Object chiNext() {
		// TODO Auto-generated method stub
		Object ret = null;
		chiCurrent++;
		
		if(chiCurrent<st.chiWords.size()) {
			ret = st.chiWords.get(chiCurrent);
		}
		
		return ret;
	}

	@Override
	public boolean chiisDone() {
		// TODO Auto-generated method stub
		return chiCurrent >= st.chiWords.size() ? true : false;
	}

	@Override
	public Object chiCurrentItem() {
		// TODO Auto-generated method stub
		return st.chiWords.get(chiCurrent);
	}
}
