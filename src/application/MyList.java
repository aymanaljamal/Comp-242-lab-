package application;

public class MyList<T extends Comparable<T>> implements Listable<T> {
    T[] list;
    int count;

    public MyList(int size) {
        list = (T[]) new Comparable[size];
        count = 0;
    }
    public void setcount(int i) {
    	count=i;
    }

    @Override
    public void add(T element) {
        if (count >= list.length) {
            resize();
        }
        list[count] = element;
        count++;
    }

    @Override
    public boolean delete(T element) {
        if (element != null) {
            for (int i = 0; i < count; i++) {
                if (list[i] != null && list[i].compareTo(element) == 0) {
                    for (int j = i; j < count - 1; j++) {
                        list[j] = list[j + 1];
                    }
                    list[count - 1] = null;
                    count--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        list = (T[]) new Comparable[0];
        count = 0; 
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean find(T element) {
        if (element != null) {
            for (int i = 0; i < count; i++) {
                if (list[i] != null && list[i].compareTo(element) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + "\t" + list[i].toString());
        }
    }

    private void resize() {
        T[] newlist = (T[]) new Comparable[list.length * 2];
        System.arraycopy(list, 0, newlist, 0, count);
        list = newlist;
    }

    public T get(int i) {
        return list[i];
    }
    public void set(T element, int i) {
		list[i] = element;
	}

	
}
