package application;

public class OHashp<T extends Comparable<T>> {

    private HNodep<T>[] hashTable;
    private int size;

    public OHashp(int n) {
        this.size = n * 2;
        hashTable = new HNodep[this.size];
        for (int i = 0; i < this.size; i++) {
            hashTable[i] = new HNodep<>(null);
        }
    }

    public void add(T data) {
        int index = Math.abs(data.hashCode() % size);
        int firstIndex = index;
        if (hashTable[index].getFlag().equals("E")) {
            hashTable[index].setData(data);
            hashTable[index].setFlag("F");
        } else {
            while (hashTable[(index + 1) % size].getFlag().equals("F")) {
                index = (index + 1) % size;
                if (index == firstIndex) {
                    System.out.println("Table is full");
                    return;
                }
            }
            hashTable[(index) % size].setData(data);
            hashTable[(index) % size].setFlag("F");
        }
    }

    public HNodep<T>[] getHashTable() {
        return hashTable;
    }

    public int getSize() {
        return size;
    }
}
