package model;

public interface Observable<T> {

	public boolean addObserver(T o);
	
	public boolean removeObserver(T o);
	
}
