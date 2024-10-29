package application;

import java.util.Arrays;

public class OHashL<A extends Comparable<A>> {
    private HNode<A>[] hashTable;
    private int size;
    private int collisionCount = 0;
    private int elementCount = 0;

    public OHashL(int n) {
        this.size = n * 2;
        hashTable = new HNode[this.size];
        for (int i = 0; i < this.size; i++) {
            hashTable[i] = new HNode<>(null);
        }
    }

    public void add(A data) {
        if (elementCount >= size / 2) {
            rehash();
        }
        int index = Math.abs(data.hashCode() % size);
        int firstIndex = index;
        boolean collided = false;
        while (hashTable[index].getFlag() == 'F') {
            collided = true;
            index = (index + 1) % size;
            if (index == firstIndex) {
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
        return "OHashL [hashTable=" + Arrays.toString(hashTable) + "]";
    }

    public void traverse() {
        System.out.println("Hash Table:");
        for (HNode<A> node : hashTable) {
            if (node.getFlag() == 'F') {
                System.out.print(node.getData().toString() + "  |   ");
            } else {
                System.out.print("Empty" + "  |   ");
            }
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return elementCount == 0;
    }

    public void rehash() {
        HNode<A>[] oldTable = hashTable;
        int oldSize = size;
        size = size * 2;
        hashTable = new HNode[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new HNode<>(null);
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
        OHashL<Integer> hashTable = new OHashL<>(5);
        hashTable.add(10);
        hashTable.add(22);
        hashTable.add(31);
        hashTable.add(4);
        hashTable.add(15);
        hashTable.add(55);
        hashTable.add(65);
        hashTable.add(75);
        hashTable.traverse();
        System.out.println("********************************************");
        System.out.println(hashTable);
        System.out.println("Average Collisions: " + hashTable.getAverageCollisions());
    }
}