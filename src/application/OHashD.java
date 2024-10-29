package application;

import java.util.Arrays;

public class OHashD<A extends Comparable<A>> {
    private HNode<A>[] hashTable;
    private int size;
    private int collisionCount = 0;
    private int elementCount = 0;

    public OHashD(int n) {
        this.size = n * 2;
        hashTable = new HNode[this.size];
        for (int i = 0; i < this.size; i++) {
            hashTable[i] = new HNode<>(null);
            hashTable[i].setFlag('E');
        }
    }

    public void add(A data) {
        if (elementCount >= size / 2) {
            rehash();
        }
        int h0 = Math.abs((data.hashCode() % size));
        int h1 = 1 + Math.abs((data.hashCode() / size) % (size - 1)); 
        int index = h0;
        int i = 0;
        boolean collided = false;

        while (hashTable[index].getFlag() == 'F') {
            collided = true;
            collisionCount++;
            i++;
            index = (h0 + i * h1) % size;
            if (i >= size) {
                System.out.println("Table is full");
                return;
            }
        }

        if (collided) {
            collisionCount++;
        }

        hashTable[index].setData(data);
        hashTable[index].setFlag('F');
        elementCount++;
    }

    public boolean con(A data) {
        int h0 = Math.abs((data.hashCode() % size));
        int h1 = 1 + Math.abs((data.hashCode() / size) % (size - 1));
        int index = h0;
        int i = 0;

        while (hashTable[index].getFlag() != 'E') {
            if (hashTable[index].getData().equals(data)) {
                return true;
            }
            i++;
            index = (h0 + i * h1) % size;
            if (i >= size) {
                return false;
            }
        }
        return false;
    }

    public double getAverageCollisions() {
        return elementCount == 0 ? 0 : (double) collisionCount / elementCount;
    }

    public HNode<A>[] getHashTable() {
        return hashTable;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "OHashD [hashTable=" + Arrays.toString(hashTable) + "]";
    }

    public void rehash() {
        HNode<A>[] oldTable = hashTable;
        int oldSize = size;
        size = size * 2;
        hashTable = new HNode[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new HNode<>(null);
            hashTable[i].setFlag('E');
        }
        collisionCount = 0;
        elementCount = 0;
        for (int i = 0; i < oldSize; i++) {
            if (oldTable[i].getFlag() == 'F') {
                add(oldTable[i].getData());
            }
        }
    }

    public static void main(String[] args) {
        OHashD<Integer> hashTable = new OHashD<>(10);
        hashTable.add(10);
        hashTable.add(20);
        hashTable.add(30);

        System.out.println(hashTable);
        System.out.println("Contains 20: " + hashTable.con(20));
        System.out.println("Contains 40: " + hashTable.con(40));
        System.out.println("Average Collisions: " + hashTable.getAverageCollisions());
    }
}


