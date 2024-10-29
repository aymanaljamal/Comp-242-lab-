package application;

public class SHash<T extends Comparable<T>> {
    private LinkedList<T>[] hashTable;
    private int size;
    private int collisionCount = 0;
    private int elementCount = 0;

    public SHash(int size) {
        this.size = size;
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public void add(T data) {
        if (elementCount >= size / 2) {
            rehash();
        }
        int index = Math.abs(data.hashCode() % size);
        if (hashTable[index].find(data) != null) {
            collisionCount++;
        }
        hashTable[index].insert(data);
        elementCount++;
    }

    public void delete(T data) {
        int index = Math.abs(data.hashCode() % size);
        hashTable[index].delete(data);
        elementCount--;
    }

    public boolean find(T data) {
        int index = Math.abs(data.hashCode() % size);
        return hashTable[index].find(data) != null;
    }

    public double getAverageCollisions() {
        return elementCount == 0 ? 0 : (double) collisionCount / elementCount;
    }

    public LinkedList<T>[] getHashTable() {
        return hashTable;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(i).append(": ").append(hashTable[i].toString()).append("\n");
        }
        return result.toString();
    }

    private void rehash() {
        LinkedList<T>[] oldTable = hashTable;
        int oldSize = size;
        size = size * 2;
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
        collisionCount = 0;
        elementCount = 0;
        for (int i = 0; i < oldSize; i++) {
            Node<T> current = oldTable[i].head;
            while (current != null) {
                add(current.getData());
                current = current.getNext();
            }
        }
    }

    public static void main(String[] args) {
        SHash<Integer> hashTable = new SHash<>(9);
        hashTable.add(10);
        hashTable.add(20);
        hashTable.add(30);
        hashTable.add(40);
        hashTable.add(50);
        hashTable.add(60);
        hashTable.add(70);
        hashTable.add(80);
        hashTable.add(10);
        hashTable.add(20);
        hashTable.add(30);
        hashTable.add(40);
        hashTable.add(50);
        hashTable.add(60);
        hashTable.add(70);
        hashTable.add(80);
        hashTable.add(10);
        hashTable.add(20);
        hashTable.add(30);
        hashTable.add(40);
        hashTable.add(50);
        hashTable.add(60);
        hashTable.add(70);
        hashTable.add(80);
        hashTable.add(10);
        hashTable.add(20);
        hashTable.add(30);
        hashTable.add(40);
        hashTable.add(50);
        hashTable.add(60);
        hashTable.add(70);
        hashTable.add(80);
        System.out.println(hashTable);

        System.out.println("Find 30: " + hashTable.find(30));
        System.out.println("Find 70: " + hashTable.find(70));

        hashTable.delete(30);
        System.out.println(hashTable);
        System.out.println("Find 30: " + hashTable.find(30));

        System.out.println("Average Collisions: " + hashTable.getAverageCollisions());
    }
}
