package wordCount_Visitor_Iterator;

public interface Iterator {
	public Object engFirst();
	public Object engNext();
	public boolean engisDone();
	public Object engCurrentItem();

	public Object chiFirst();
	public Object chiNext();
	public boolean chiisDone();
	public Object chiCurrentItem();
}

