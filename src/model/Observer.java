package model;

public interface Observer {

	/**
	 * Event produced after a store
	 * @param b Outcome of the store
	 */
	public void onStore(boolean b);
	
}
