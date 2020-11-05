package wordCount_Visitor_Iterator;

public interface Visitor {
	public void visit(EnglishWord ew);
	public void visit(AnotherWord cw);
	public int getWordCount();
}
