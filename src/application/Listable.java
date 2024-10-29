package application;

public interface Listable<T extends Comparable<T>> {

	public void add(T elmant);

	public boolean delete(T elmant);

	public void clear();

	public boolean isEmpty();

	public int size();

	public boolean find(T elmant);

	public void traverse();

	

}
